package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Franchise;
import com.coffeeFranchise.repository.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    private final FranchiseRepository franchiseRepository;

    public FranchiseController(@Autowired FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @GetMapping
    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    @PostMapping
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchiseById(@PathVariable Integer id) {
        return franchiseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Integer id, @RequestBody Franchise franchiseDetails) {
        return franchiseRepository.findById(id)
                .map(franchise -> {
                    franchise.setLocation(franchiseDetails.getLocation());
                    // Добавьте здесь обновление других полей франшизы, если они есть
                    Franchise updatedFranchise = franchiseRepository.save(franchise);
                    return ResponseEntity.ok(updatedFranchise);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFranchise(@PathVariable Integer id) {
        return franchiseRepository.findById(id)
                .map(franchise -> {
                    franchiseRepository.delete(franchise);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}