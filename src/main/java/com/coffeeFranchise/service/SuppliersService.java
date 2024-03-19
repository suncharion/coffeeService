package com.coffeeFranchise.service;

import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Suppliers;
import com.coffeeFranchise.repository.SuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;

    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    public Suppliers createSupplier(Suppliers supplier) {
        return suppliersRepository.save(supplier);
    }

    public Suppliers getSupplierById(Long id) {
        return suppliersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));
    }

    public Suppliers updateSupplier(Long id, Suppliers supplierDetails) {
        Suppliers supplier = getSupplierById(id);
        supplier.setSupplierName(supplierDetails.getSupplierName());
        supplier.setFranchise(supplierDetails.getFranchise());
        return suppliersRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        Suppliers supplier = getSupplierById(id);
        suppliersRepository.delete(supplier);
    }
}