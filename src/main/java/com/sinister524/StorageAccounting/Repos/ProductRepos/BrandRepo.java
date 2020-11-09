package com.sinister524.StorageAccounting.Repos.ProductRepos;


import com.sinister524.StorageAccounting.Entity.Products.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
}
