package com.coffeeFranchise.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@Entity
@Table(name = "suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierName;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private Set<Supplies> supplies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    public Suppliers() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Suppliers;
    }

}