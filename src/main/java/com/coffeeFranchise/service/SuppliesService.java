package com.coffeeFranchise.service;

import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Supplies;
import com.coffeeFranchise.repository.SuppliesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliesService {

    private final SuppliesRepository suppliesRepository;

    public SuppliesService(SuppliesRepository suppliesRepository) {
        this.suppliesRepository = suppliesRepository;
    }

    public List<Supplies> getAllSupplies() {
        return suppliesRepository.findAll();
    }

    public Supplies createSupplies(Supplies supplies) {
        return suppliesRepository.save(supplies);
    }

    public Supplies getSuppliesById(Long id) {
        return suppliesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplies not found with id: " + id));
    }

    public Supplies updateSupplies(Long id, Supplies suppliesDetails) {
        Supplies supplies = getSuppliesById(id);
        supplies.setItem(suppliesDetails.getItem());
        supplies.setQuantity(suppliesDetails.getQuantity());
        return suppliesRepository.save(supplies);
    }

    public void deleteSupplies(Long id) {
        Supplies supplies = getSuppliesById(id);
        suppliesRepository.delete(supplies);
    }
}