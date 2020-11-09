package com.sinister524.StorageAccounting.Repos.ProductRepos;


import com.sinister524.StorageAccounting.Entity.Products.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {
}
