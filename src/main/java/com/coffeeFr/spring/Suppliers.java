package com.coffeeFr.spring;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String supplierName;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private Set<Supplies> supplies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    public int getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Set<Supplies> getSupplies() {
        return supplies;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplies(Set<Supplies> supplies) {
        this.supplies = supplies;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}