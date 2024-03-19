package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Franchise;
import com.coffeeFranchise.model.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliesRepository extends JpaRepository<Supplies, Long> {
}
