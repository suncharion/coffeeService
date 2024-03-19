package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Shifts;
import com.coffeeFranchise.service.ShiftsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shifts")
public class ShiftsController {

    private final ShiftsService shiftsService;

    public ShiftsController(ShiftsService shiftsService) {
        this.shiftsService = shiftsService;
    }

    @GetMapping
    public List<Shifts> getAllShifts() {
        return shiftsService.getAllShifts();
    }

    @PostMapping
    public Shifts createShift(@RequestBody Shifts shift) {
        return shiftsService.createShift(shift);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shifts> updateShift(@PathVariable Long id, @RequestBody Shifts shiftDetails) {
        Shifts updatedShift = shiftsService.updateShift(id, shiftDetails);
        return ResponseEntity.ok(updatedShift);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShift(@PathVariable Long id) {
        shiftsService.deleteShift(id);
        return ResponseEntity.ok().build();
    }
}