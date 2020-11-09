package com.sinister524.StorageAccounting.Entity.Products;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type")
public class ProductType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    @OneToMany(mappedBy = "product")
    private Set<Product> products;

    public ProductType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
