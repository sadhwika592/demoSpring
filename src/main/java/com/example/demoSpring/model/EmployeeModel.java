package com.example.demoSpring.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees_pra", schema = "endeavour_test_area")
public class EmployeeModel {

    @Id
    @Column(name = "employeeid")
    private int employeeId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "hiredate")
    private LocalDate hireDate;

    @Column(name = "departmentid")
    private Integer departmentId;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "managerid")
    private Integer managerId;

    @Column(name = "gender")
    private Integer gender;

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }

    public Integer getGender() { return gender; }
    public void setGender(Integer gender) { this.gender = gender; }
}
