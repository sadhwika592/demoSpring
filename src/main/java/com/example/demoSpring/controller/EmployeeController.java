package com.example.demoSpring.controller;

import com.example.demoSpring.dto.EmployeeDTO;
import com.example.demoSpring.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(DataSource dataSource) {
        this.service = new EmployeeService(dataSource);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getPaginatedEmployees")
    @ResponseBody
    public List<EmployeeDTO> getPaginatedEmployees(
            @RequestParam int pageNum,
            @RequestParam int pageSize) {
        return service.getPaginatedEmployees(pageNum, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getEmployee")
    @ResponseBody
    public EmployeeDTO getEmployeeById(@RequestParam int id) {
        return service.getEmployeeById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/SaveEmployee")
    @ResponseBody
    public String addEmployee(@RequestParam int id,
                              @RequestParam String name,
                              @RequestParam String department,
                              @RequestParam double salary) {
        EmployeeDTO emp = new EmployeeDTO();
        emp.setId(id);
        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        return service.addEmployee(emp);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/UpdateEmployee")
    @ResponseBody
    public String updateEmployee(@RequestParam int id,
                                 @RequestParam String name,
                                 @RequestParam String department,
                                 @RequestParam double salary) {
        EmployeeDTO emp = new EmployeeDTO();
        emp.setId(id);
        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        return service.updateEmployee(emp);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/DeleteEmployee")
    @ResponseBody
    public String deleteEmployee(@RequestParam int id) {
        return service.deleteEmployee(id);
    }
}
