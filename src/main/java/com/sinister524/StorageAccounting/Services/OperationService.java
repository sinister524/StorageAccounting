package com.sinister524.StorageAccounting.Services;

import com.sinister524.StorageAccounting.Entity.Contractors.*;
import com.sinister524.StorageAccounting.Entity.Products.Product;
import com.sinister524.StorageAccounting.Repos.ContractorsRepos.ContractRepo;
import com.sinister524.StorageAccounting.Repos.ContractorsRepos.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OperationService {

    @Autowired
    OperationRepo operationRepo;

    @Autowired
    ContractRepo contractRepo;

    public void saveOperation (Operation operation) {
        operationRepo.save(operation);
    }

    @Cacheable("balance")
    public Map<Product, Integer> getBalance(Date date) {
        return operationRepo.findAllPerformedLessThanEqualDateOrderByDate(date).stream()
                .filter(operation -> operation.getType() != OperationType.REJECT)
                .sorted(Comparator.comparing(Operation::getDate))
                .flatMap(operation -> operation.getOperationProducts().stream())
                .peek(operationProduct -> {
                    if (operationProduct.getOperation().isDecline()){
                        operationProduct.setQuantity(-operationProduct.getQuantity());}
                })
                .collect(Collectors.groupingBy(OperationProduct::getProduct, Collectors.summingInt(OperationProduct::getQuantity)));
    }

    @Cacheable("contractBalance")
    public Map<Product, Integer> getContractBalance(Contract contract){
        return operationRepo.findAllByContractOrderByDate(contract).stream()
            .filter(operation -> !(operation.getType().equals(OperationType.BUYING) || operation.getType().equals(OperationType.SELLING)
                    || operation.getType().equals(OperationType.REJECT) || operation.getType().equals(OperationType.RESTORE))
                    && operation.isPerformed())
            .flatMap(operation -> operation.getOperationProducts().stream())
            .peek(operationProduct -> {
                if (!operationProduct.getOperation().isDecline()){
                    operationProduct.setQuantity(-operationProduct.getQuantity());}
            })
            .collect(Collectors.groupingBy(OperationProduct::getProduct, Collectors.summingInt(OperationProduct::getQuantity)));
    }

    @Cacheable("contractorBalance")
    public Map<Product, Integer> getContractorBalance (Contractor contractor){
        return contractor.getContracts().stream()
                .flatMap(contract -> getContractBalance(contract).entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
    }
}
