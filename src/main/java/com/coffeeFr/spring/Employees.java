package com.coffeeFr.spring;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeeName;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Shifts> shifts;


    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Set<Shifts> getShifts() {
        return shifts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setShifts(Set<Shifts> shifts) {
        this.shifts = shifts;
    }
}