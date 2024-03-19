package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Supplies;
import com.coffeeFranchise.service.SuppliesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplies")
public class SuppliesController {

    private final SuppliesService suppliesService;

    public SuppliesController(SuppliesService suppliesService) {
        this.suppliesService = suppliesService;
    }

    @GetMapping
    public List<Supplies> getAllSupplies() {
        return suppliesService.getAllSupplies();
    }

    @PostMapping
    public Supplies addSupplies(@RequestBody Supplies supplies) {
        return suppliesService.createSupplies(supplies);
    }
}