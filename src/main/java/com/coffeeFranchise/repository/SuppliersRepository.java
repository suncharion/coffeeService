package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Franchise;
import com.coffeeFranchise.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Suppliers, Integer> {
}
