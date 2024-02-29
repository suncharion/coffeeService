package com.coffeeFr.spring;

import javax.persistence.*;

@Entity
@Table(name = "CoffeeBeans")
public class CoffeeBeans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String beanName;
    private String beanType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franchise")
    private Franchise franchise;

    public int getId() {
        return id;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getBeanType() {
        return beanType;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }
}