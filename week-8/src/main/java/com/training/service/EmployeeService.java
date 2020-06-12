package com.training.service;

import com.training.dao.DAO;
import com.training.exceptions.DbInsertionFailedException;
import com.training.exceptions.InvalidDetailsException;
import com.training.interfaces.IEmployeeService;
import com.training.models.Employee;

public class EmployeeService implements IEmployeeService {
    private DAO db;
    private Employee employee;

    public EmployeeService() {
        super();
    }

    public DAO getDb() {
        return db;
    }

    public void setDb(DAO db) {
        this.db = db;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean validateEmployeeDetails() throws InvalidDetailsException, DbInsertionFailedException {
        String empName = employee.getEmpName();
        int empId = employee.getEmpId();
        boolean res = false;
        if(empName.length()  < 4 && empId < 0) {
            throw new InvalidDetailsException(empName, empId);
        } else if(empName.length() < 4) {
            throw new InvalidDetailsException(empName);
        } else if(empId < 0) {
            throw new InvalidDetailsException(empId);
        } else {
            try {
                res = this.addEmployee();
            } catch (DbInsertionFailedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public boolean addEmployee() throws DbInsertionFailedException {
        boolean res = db.insert(employee);
        if(res) {
            System.out.println("[Employee Service] employee added successfully");
        } else {
            System.out.println("[Employee Service] not able to add employee to DB");
        }
        return res;
    }
}
