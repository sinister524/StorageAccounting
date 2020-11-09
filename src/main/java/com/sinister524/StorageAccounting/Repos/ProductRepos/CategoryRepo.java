package com.sinister524.StorageAccounting.Repos.ProductRepos;


import com.sinister524.StorageAccounting.Entity.Products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
