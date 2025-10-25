package com.example.demoSpring.service;

import com.example.demoSpring.model.EmployeeModel;
import com.example.demoSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeJPAService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeModel> getAllEmployees() {
        return repository.findAll();
    }
}
