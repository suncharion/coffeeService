package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Long> {
}
