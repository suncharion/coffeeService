package com.coffeeFranchise.repository;

import com.coffeeFranchise.dto.OrderDTO;
import com.coffeeFranchise.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<OrderDTO,Long> {
}
