package com.sinister524.StorageAccounting.Repos.ContractorsRepos;


import com.sinister524.StorageAccounting.Entity.Contractors.Contract;
import com.sinister524.StorageAccounting.Entity.Contractors.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepo extends JpaRepository<Contract, Long> {

    List<Contract> findAllByContractor (Contractor contractor);
}
