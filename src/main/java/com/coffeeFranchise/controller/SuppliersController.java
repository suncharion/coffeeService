package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Suppliers;
import com.coffeeFranchise.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    private final SuppliersRepository suppliersRepository;

    public SuppliersController(@Autowired SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    @GetMapping
    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    @PostMapping
    public Suppliers createSupplier(@RequestBody Suppliers supplier) {
        return suppliersRepository.save(supplier);
    }
}