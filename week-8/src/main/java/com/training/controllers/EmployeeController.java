package com.training.controllers;

import com.training.exceptions.DbInsertionFailedException;
import com.training.exceptions.InvalidDetailsException;
import com.training.models.Employee;
import com.training.service.EmployeeService;

public class EmployeeController {
    private Employee employee;
    private EmployeeService employeeService;

    public EmployeeController(Employee employee) {
        this.employee = employee;
    }

    public EmployeeController() {
        super();
    }

    public boolean addEmployeeInDb() throws DbInsertionFailedException, InvalidDetailsException {
        if(employeeService.validateEmployeeDetails()) {
            System.out.println("[Employee Controller] Success");
            return true;
        } else {
            System.out.println("[Employee Controller] Failure");
            return false;
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String toString() {
        return "EmployeeController{" +
                "employee=" + employee +
                '}';
    }
}
