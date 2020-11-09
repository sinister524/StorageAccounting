package com.sinister524.StorageAccounting.Repos.ProductRepos;


import com.sinister524.StorageAccounting.Entity.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
