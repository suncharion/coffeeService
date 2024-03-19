package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Franchise;
import com.coffeeFranchise.service.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping
    public List<Franchise> getAllFranchises() {
        return franchiseService.getAllFranchises();
    }

    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.createFranchise(franchise);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchiseById(@PathVariable Long id) {
        Franchise franchise = franchiseService.getFranchiseById(id);
        return ResponseEntity.ok(franchise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long id, @RequestBody Franchise franchiseDetails) {
        Franchise updatedFranchise = franchiseService.updateFranchise(id, franchiseDetails);
        return ResponseEntity.ok(updatedFranchise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFranchise(@PathVariable Long id) {
        franchiseService.deleteFranchise(id);
        return ResponseEntity.ok().build();
    }
}