package com.coffeeFr.spring;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Supplies")
public class Supplies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime deliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franchise")
    private Franchise franchise;

    public int getId() {
        return id;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}
