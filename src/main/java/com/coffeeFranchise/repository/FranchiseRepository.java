package com.coffeeFranchise.repository;

import com.coffeeFranchise.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

}

