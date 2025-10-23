package com.example.demoSpring.service;

import com.example.demoSpring.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private DataSource dataSource;

    public List<EmployeeDTO> getPaginatedEmployees(int pageNum, int pageSize) {
        List<EmployeeDTO> list = new ArrayList<>();
        String query = "SELECT * FROM endeavour_test_area.get_employees_sadhwika_crud(?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, pageNum);
            ps.setInt(2, pageSize);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeDTO emp = new EmployeeDTO();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public EmployeeDTO getEmployeeById(int id) {
        EmployeeDTO emp = null;
        String sql = "SELECT id, name, department, salary FROM endeavour_test_area.employees_sadhwika_crud WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new EmployeeDTO();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public String addEmployee(EmployeeDTO emp) {
        String message;
        try (Connection conn = dataSource.getConnection();
             CallableStatement cs = conn.prepareCall("{ call endeavour_test_area.add_employee_sadhwika_crud(?, ?, ?, ?) }")) {

            cs.setInt(1, emp.getId());
            cs.setString(2, emp.getName());
            cs.setString(3, emp.getDepartment());
            cs.setDouble(4, emp.getSalary());
            cs.execute();
            message = "Employee added successfully";

        } catch (SQLException e) {
            message = "Error adding employee: " + e.getMessage();
        }
        return message;
    }


    public String updateEmployee(EmployeeDTO emp) {
        String message;
        try (Connection conn = dataSource.getConnection();
             CallableStatement cs = conn.prepareCall("{ call endeavour_test_area.update_employee_sadhwika_crud(?, ?, ?, ?) }")) {

            cs.setInt(1, emp.getId());
            cs.setString(2, emp.getName());
            cs.setString(3, emp.getDepartment());
            cs.setDouble(4, emp.getSalary());
            cs.execute();
            message = "Employee updated successfully";

        } catch (SQLException e) {
            message = "Error updating employee: " + e.getMessage();
        }
        return message;
    }

    public String deleteEmployee(int id) {
        String message;
        try (Connection conn = dataSource.getConnection();
             CallableStatement cs = conn.prepareCall("{ call endeavour_test_area.delete_employee_sadhwika_crud(?) }")) {

            cs.setInt(1, id);
            cs.execute();
            message = "Employee deleted successfully";

        } catch (SQLException e) {
            message = "Error deleting employee: " + e.getMessage();
        }
        return message;
    }
}
