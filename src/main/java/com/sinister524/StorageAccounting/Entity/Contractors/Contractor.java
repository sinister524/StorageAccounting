package com.sinister524.StorageAccounting.Entity.Contractors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contractor")
public class Contractor {

    @Id
    private Long id;

    private String name;

    private String phone;

    private String address;

    @Transient
    @OneToMany(mappedBy = "contract")
    private Set<Contract> contracts;

    public Contractor() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
