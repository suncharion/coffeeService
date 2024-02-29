package com.coffeeFr.spring;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id")
    private Shifts shift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_id") // Это должно соответствовать имени столбца в таблице Orders, который ссылается на Franchise
    private Franchise franchise;

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public Shifts getShift() {
        return shift;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setShift(Shifts shift) {
        this.shift = shift;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

}