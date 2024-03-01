package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
