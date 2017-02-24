package com.lijubjohn;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liju on 2/22/17.
 *
 * Service supporting CRUD operations for employee
 */
public class EmployeeService {

    private final EmployeeDAO empDAO;

    public EmployeeService(EmployeeDAO empDAO) {
        this.empDAO = empDAO;
    }

    public void addEmployee(Employee emp) throws SQLException {
        empDAO.addEmployee(emp);
    }

    public void deleteEmployee(int id) throws SQLException {
        empDAO.deleteEmployee(id);
    }

    public void updateEmployee(Employee emp) throws SQLException {
        empDAO.updateEmployee(emp);
    }

    public Employee getEmployee(int id) throws SQLException {
        return empDAO.getEmployee(id);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return empDAO.getAllEmployees();
    }
}
