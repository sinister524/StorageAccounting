package com.sinister524.StorageAccounting.Entity.Contractors;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    private boolean performed;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @Transient
    @OneToMany(mappedBy = "operation_product")
    private Set<OperationProduct> operationProducts;


    public Operation() {
    }

    public Operation(Date date, OperationType type, boolean performed, Contract contract, Set<OperationProduct> operationProducts) {
        this.date = date;
        this.type = type;
        this.performed = performed;
        this.contract = contract;
        this.operationProducts = operationProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPerformed() {
        return performed;
    }

    public void setPerformed(boolean performed) {
        this.performed = performed;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Set<OperationProduct> getOperationProducts() {
        return operationProducts;
    }

    public void setOperationProducts(Set<OperationProduct> operationProducts) {
        this.operationProducts = operationProducts;
    }

    public boolean isDecline () {
        return type.equals(OperationType.SELLING) || type.equals(OperationType.SENDING);
    }
}
