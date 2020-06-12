package com.training.junitTests;

import com.training.dao.DAO;
import com.training.exceptions.DbInsertionFailedException;
import com.training.exceptions.InvalidDetailsException;
import com.training.models.Employee;
import com.training.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    EmployeeService employeeService;
    /**
     * Rigorous Test :-)
     */

    // negative empid
    @Test(expected=InvalidDetailsException.class)
    public void negativeId() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(-1, "Pan", "SDE1");
        employeeService = new EmployeeService(employee);
        assertEquals(InvalidDetailsException.class, employeeService.validateEmployeeDetails() );
    }

    // test case with valid inputs
    @Test
    public void validNameAndId() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pankil", "SDE1");
        employeeService = new EmployeeService(employee);
        employeeService.setDb(new DAO());
        assertTrue(employeeService.validateEmployeeDetails() );
    }

    // emp name less than 4 characters
    @Test(expected=InvalidDetailsException.class)
    public void nameLessThan() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pan", "SDE1");
        employeeService = new EmployeeService(employee);
        assertEquals(InvalidDetailsException.class, employeeService.validateEmployeeDetails() );
    }

    @After
    public void destroy() {
        employeeService = null;
    }

}
