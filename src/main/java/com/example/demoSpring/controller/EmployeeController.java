package com.example.demoSpring.controller;

import com.example.demoSpring.dto.EmployeeDTO;
import com.example.demoSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean deleted = service.deleteEmployee(id);
        return deleted ? "Employee deleted successfully!" : "Employee not found!";
    }
}
