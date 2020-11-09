package com.sinister524.StorageAccounting.Entity.Contractors;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OperationProductId implements Serializable {

    private Long operationId;

    private Long productId;

    public OperationProductId() {
    }

    public OperationProductId(Long operationId, Long productId) {
        this.operationId = operationId;
        this.productId = productId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
