package com.sinister524.StorageAccounting.Repos.ContractorsRepos;


import com.sinister524.StorageAccounting.Entity.Contractors.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepo extends JpaRepository<Contractor, Long> {
}
