package com.coffeeFranchise.model;

import com.coffeeFranchise.model.enums.BeanType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String beanName;
    private BeanType beanType;
    private String snacks;
    private String milk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franchise")
    private Franchise franchise;

    public Stock() {
    }

}