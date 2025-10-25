package com.example.demoSpring.controller;

import com.example.demoSpring.model.EmployeeModel;
import com.example.demoSpring.service.EmployeeJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeJPAController {

    @Autowired
    private EmployeeJPAService service;

    @GetMapping("/getAll")
    public List<EmployeeModel> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/getById/{id}")
    public Optional<EmployeeModel> getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/add")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel emp) {
        return service.addEmployee(emp);
    }

    @PutMapping("/update")
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel emp) {
        return service.updateEmployee(emp);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

}
