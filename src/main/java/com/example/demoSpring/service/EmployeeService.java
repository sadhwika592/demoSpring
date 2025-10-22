package com.example.demoSpring.service;

import com.example.demoSpring.dto.EmployeeDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<EmployeeDTO> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new EmployeeDTO(1, "Sadhwika", "Software Developer", 60000));
        employees.add(new EmployeeDTO(2, "Rahul", "HR", 50000));
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employees;
    }

    public EmployeeDTO getEmployeeById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public EmployeeDTO addEmployee(EmployeeDTO emp) {
        employees.add(emp);
        return emp;
    }

    public EmployeeDTO updateEmployee(int id, EmployeeDTO emp) {
        for (EmployeeDTO e : employees) {
            if (e.getId() == id) {
                e.setName(emp.getName());
                e.setDepartment(emp.getDepartment());
                e.setSalary(emp.getSalary());
                return e;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
