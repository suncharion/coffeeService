package com.coffeeFranchise.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Shifts> shifts;


}