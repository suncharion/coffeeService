package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Employees;
import com.coffeeFranchise.service.EmployeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesService employeeService;

    public EmployeesController(EmployeesService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Long id) {
        Employees employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Long id, @RequestBody Employees employeeDetails) {
        Employees updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}