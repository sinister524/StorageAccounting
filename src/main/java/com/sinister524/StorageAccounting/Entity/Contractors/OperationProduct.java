package com.sinister524.StorageAccounting.Entity.Contractors;

import com.sinister524.StorageAccounting.Entity.Products.Product;

import javax.persistence.*;

@Entity
public class OperationProduct {

    @EmbeddedId
    private OperationProductId operationProductId = new OperationProductId();

    @MapsId("operationId")
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Operation operation;

    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public OperationProduct() {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
