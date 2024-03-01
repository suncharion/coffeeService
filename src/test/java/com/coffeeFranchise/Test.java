package com.coffeeFranchise;

import com.coffeeFranchise.model.Franchise;
import com.coffeeFranchise.repository.FranchiseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {

    private final FranchiseRepository franchiseRepository;

    public Test(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Franchise franchise = new Franchise();
        franchise.setLocation("TestLocationBaumanskaya1337");
        franchiseRepository.save(franchise);
    }
}

