package com.coffeeFranchise.service;

import com.coffeeFranchise.exceptions.EntityNotFoundException;
import com.coffeeFranchise.model.Employees;
import com.coffeeFranchise.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public Employees createEmployee(Employees employee) {
        return employeesRepository.save(employee);
    }

    public Employees getEmployeeById(Long id) {
        return employeesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Employees updateEmployee(Long id, Employees employeeDetails) {
        Employees employee = getEmployeeById(id);
        employee.setEmployeeName(employeeDetails.getEmployeeName());
        return employeesRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employees employee = getEmployeeById(id);
        employeesRepository.delete(employee);
    }
}