package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Shifts;
import com.coffeeFranchise.repository.ShiftsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shifts")
public class ShiftsController {

    private final ShiftsRepository shiftsRepository;

    public ShiftsController(@Autowired ShiftsRepository shiftsRepository) {
        this.shiftsRepository = shiftsRepository;
    }

    @GetMapping
    public List<Shifts> getAllShifts() {
        return shiftsRepository.findAll();
    }

    @PostMapping
    public Shifts createShift(@RequestBody Shifts shift) {
        return shiftsRepository.save(shift);
    }
}