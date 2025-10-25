package com.example.demoSpring.controller;

import com.example.demoSpring.model.EmployeeModel;
import com.example.demoSpring.service.EmployeeJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
