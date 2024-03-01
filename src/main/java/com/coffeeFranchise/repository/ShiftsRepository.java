package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftsRepository extends JpaRepository<Shifts, Integer> {
}
