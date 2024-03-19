package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Suppliers;
import com.coffeeFranchise.service.SuppliersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

    private final SuppliersService suppliersService;

    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @GetMapping
    public List<Suppliers> getAllSuppliers() {
        return suppliersService.getAllSuppliers();
    }

    @PostMapping
    public Suppliers createSupplier(@RequestBody Suppliers supplier) {
        return suppliersService.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> getSupplierById(@PathVariable Long id) {
        Suppliers supplier = suppliersService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> updateSupplier(@PathVariable Long id, @RequestBody Suppliers supplierDetails) {
        Suppliers updatedSupplier = suppliersService.updateSupplier(id, supplierDetails);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        suppliersService.deleteSupplier(id);
        return ResponseEntity.ok().build();
    }
}