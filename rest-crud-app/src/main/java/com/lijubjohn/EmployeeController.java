package com.lijubjohn;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by liju on 2/22/17.
 *
 * Webservice supporting CRUD operations for Employee
 */
@Path("/employee")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee(Employee emp) throws RestException {
        try {
            empService.addEmployee(emp);
        } catch (SQLException e) {
            throw new RestException("Error adding employee", e);
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEmployee(@PathParam("id") int id) throws RestException {
        try {
            empService.deleteEmployee(id);
        } catch (SQLException e) {
            throw new RestException("Error deleting employee with id = " + id, e);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployee(Employee emp) throws RestException {
        try {
            empService.updateEmployee(emp);
        } catch (SQLException e) {
            throw new RestException("Error updating employee with id = " + emp.getEmpId(), e);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") int id) throws RestException, EmployeeNotFoundEx {
        try {
            final Employee employee = empService.getEmployee(id);
            if (employee == null) {
                throw new EmployeeNotFoundEx("No employee found with id = " + id);
            }
            return employee;
        } catch (SQLException e) {
            throw new RestException("Error retrieving employee with id = " + id, e);
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployees() throws EmployeeNotFoundEx, RestException {
        try {
            final List<Employee> allEmployees = empService.getAllEmployees();
            if (allEmployees.size() == 0) {
                throw new EmployeeNotFoundEx("No employee found");
            }
            return allEmployees;
        } catch (SQLException e) {
            throw new RestException("Error retrieving all employees", e);
        }
    }
}
