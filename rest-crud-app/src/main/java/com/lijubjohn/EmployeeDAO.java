package com.lijubjohn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 2/22/17.
 *
 * DAO class supporting CRUD operations for Employee
 */
public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee emp) throws SQLException {
        String sql ="INSERT INTO EMPLOYEE (first_name,last_name,dept) values (?,?,?)";
        final PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,emp.getFirstName());
        ps.setString(2,emp.getLastName());
        ps.setString(3,emp.getDept());
        ps.execute();
        connection.commit();
        ps.close();
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql ="DELETE from EMPLOYEE where id = ?";
        final PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.execute();
        connection.commit();
        ps.close();
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql ="UPDATE EMPLOYEE SET first_name = ? ,last_name = ?,dept = ? where id = ?";
        final PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,emp.getFirstName());
        ps.setString(2,emp.getLastName());
        ps.setString(3,emp.getDept());
        ps.setInt(4,emp.getEmpId());
        ps.execute();
        connection.commit();
        ps.close();
    }

    public Employee getEmployee(int id) throws SQLException {
        String sql = "SELECT * from EMPLOYEE WHERE ID = ?";
        final PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        final ResultSet rs = ps.executeQuery();
        Employee emp =null;
        while (rs.next()){
            emp = new Employee();
            emp.setEmpId(rs.getInt("id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setDept(rs.getString("dept"));
            break;
        }
        ps.close();
        return emp;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "SELECT * from EMPLOYEE";
        final PreparedStatement ps = connection.prepareStatement(sql);
        final ResultSet rs = ps.executeQuery();
        List<Employee> list = new ArrayList<>();
        while (rs.next()){
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setDept(rs.getString("dept"));
            list.add(emp);
        }
        ps.close();
        return list;
    }
}
