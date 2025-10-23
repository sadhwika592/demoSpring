package com.example.demoSpring.controller;

import com.example.demoSpring.dto.EmployeeDTO;
import com.example.demoSpring.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Operation(summary = "Fetch paginated employees",
            description = "Uses PostgreSQL function get_employees_sadhwika_crud()")

    @GetMapping("/page/{pageNum}/size/{pageSize}")
    public List<EmployeeDTO> getPaginatedEmployees(@PathVariable int pageNum, @PathVariable int pageSize) {
//        System.out.println("Fetching employees for pageNum=" + pageNum + ", pageSize=" + pageSize);
        return service.getPaginatedEmployees(pageNum, pageSize);
    }

    @Operation(summary = "Fetch employee by ID",
            description = "Fetch single employee record by ID")

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @Operation(summary = "Add new employee",
            description = "Calls PostgreSQL function add_employee_sadhwika_crud()")

    @PostMapping
    public String addEmployee(@RequestBody EmployeeDTO emp) {
        return service.addEmployee(emp);
    }

    @Operation(summary = "Update employee",
            description = "Calls PostgreSQL function update_employee_sadhwika_crud()")

    @PutMapping
    public String updateEmployee(@RequestBody EmployeeDTO emp) {
        return service.updateEmployee(emp);
    }

    @Operation(summary = "Delete employee by ID",
            description = "Calls PostgreSQL function delete_employee_sadhwika_crud()")

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
