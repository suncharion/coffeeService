package com.coffeeFranchise.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "supplies")
public class Supplies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Item;
    private String Quantity;

    private Instant deliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franchise")
    private Franchise franchise;

}
