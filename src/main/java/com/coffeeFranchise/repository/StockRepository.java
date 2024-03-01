package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
