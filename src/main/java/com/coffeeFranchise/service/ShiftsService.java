package com.coffeeFranchise.service;

import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Shifts;
import com.coffeeFranchise.repository.ShiftsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftsService {

    private final ShiftsRepository shiftsRepository;

    public ShiftsService(ShiftsRepository shiftsRepository) {
        this.shiftsRepository = shiftsRepository;
    }

    public List<Shifts> getAllShifts() {
        return shiftsRepository.findAll();
    }

    public Shifts createShift(Shifts shift) {
        return shiftsRepository.save(shift);
    }


    public Shifts updateShift(Long id, Shifts shiftDetails) {
        Shifts existingShift = shiftsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shift not found with id: " + id));
        existingShift.setStartTime(shiftDetails.getStartTime());
        existingShift.setEndTime(shiftDetails.getEndTime());
        existingShift.setEmployee(shiftDetails.getEmployee());
        return shiftsRepository.save(existingShift);
    }

    public void deleteShift(Long id) {
        Shifts existingShift = shiftsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shift not found with id: " + id));
        shiftsRepository.delete(existingShift);
    }

}