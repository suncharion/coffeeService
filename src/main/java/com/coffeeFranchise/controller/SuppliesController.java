package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Supplies;
import com.coffeeFranchise.repository.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplies")
public class SuppliesController {

    private final SuppliesRepository suppliesRepository;

    public SuppliesController(@Autowired SuppliesRepository suppliesRepository) {
        this.suppliesRepository = suppliesRepository;
    }

    @GetMapping
    public List<Supplies> getAllSupplies() {
        return suppliesRepository.findAll();
    }

    @PostMapping
    public Supplies addSupplies(@RequestBody Supplies supplies) {
        return suppliesRepository.save(supplies);
    }

    @PutMapping("/{id}")
    public Supplies updateSupplies(@PathVariable Integer id, @RequestBody Supplies suppliesDetails) {
        Supplies supplies = suppliesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplies not found with id " + id));
        supplies.setDeliveryDate(suppliesDetails.getDeliveryDate());
        supplies.setSupplier(suppliesDetails.getSupplier());
        supplies.setFranchise(suppliesDetails.getFranchise());
        return suppliesRepository.save(supplies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplies(@PathVariable Integer id) {
        Supplies supplies = suppliesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplies not found with id " + id));
        suppliesRepository.delete(supplies);
        return ResponseEntity.ok().build();
    }
}