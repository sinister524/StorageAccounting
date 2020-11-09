package com.sinister524.StorageAccounting.Repos.ContractorsRepos;


import com.sinister524.StorageAccounting.Entity.Contractors.Contract;
import com.sinister524.StorageAccounting.Entity.Contractors.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OperationRepo extends JpaRepository<Operation, Long> {

    List<Operation> findAllPerformedLessThanEqualDateOrderByDate(Date date);

    List<Operation> findAllByContractOrderByDate(Contract contract);
}
