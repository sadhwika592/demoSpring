//service = bean create and stores them in the application context
//autowired = bean inject

package com.example.demoSpring.controller;

import com.example.demoSpring.dto.EmployeeDTO;
import com.example.demoSpring.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //handles REST API calls, automatically converts EmployeeDTO into JSON
@RequestMapping("/employees") //Base URL for all endpoints
public class EmployeeController {

    @Autowired //don't have to manually create instances/objects for EmployeeService
    private EmployeeService service;
    //private EmployeeService service = new EmployeeService(); manually creating without SpringBoot
    //If multiple classes depend on EmployeeService, each one creates a new copy — wasting memory.
    //I already have an object of EmployeeService in my container — let me inject it here

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @Operation(summary="This gives lst of all the Employees", description="returns list of all Employees")

    @GetMapping("/{id}") //extracts id from the URL
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
