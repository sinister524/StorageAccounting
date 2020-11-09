package com.sinister524.StorageAccounting.Entity.Contractors;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    private Long id;

    private String number;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;

    @Transient
    @OneToMany(mappedBy = "operation")
    private Set<Operation> operations;

    public Contract() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
