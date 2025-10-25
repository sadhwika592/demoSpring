package com.example.demoSpring.service;

import com.example.demoSpring.model.EmployeeModel;
import com.example.demoSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeJPAService {

    @Autowired
    private EmployeeRepository repository;

    //get all employees
    public List<EmployeeModel> getAllEmployees() {
        return repository.findAll();
    }

    //get all employees by id
    public Optional<EmployeeModel> getEmployeeById(int id) {
        return repository.findById(id);
    }

    // add new employee
    public EmployeeModel addEmployee(EmployeeModel emp) {
        return repository.save(emp);
    }

    // edit existing employee
    public EmployeeModel updateEmployee(EmployeeModel emp) {
        return repository.save(emp); // save() works for both insert/update
    }

    // Delete employee by ID
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
