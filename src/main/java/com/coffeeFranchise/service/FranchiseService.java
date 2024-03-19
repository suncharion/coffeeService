package com.coffeeFranchise.service;


import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Franchise;
import com.coffeeFranchise.repository.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Franchise getFranchiseById(Long id) {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Franchise not found with id: " + id));
    }

    public Franchise updateFranchise(Long id, Franchise franchiseDetails) {
        Franchise franchise = getFranchiseById(id);
        franchise.setLocation(franchiseDetails.getLocation());
        return franchiseRepository.save(franchise);
    }

    public void deleteFranchise(Long id) {
        Franchise franchise = getFranchiseById(id);
        franchiseRepository.delete(franchise);
    }
}
