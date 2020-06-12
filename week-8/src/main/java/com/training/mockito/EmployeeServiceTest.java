package com.training.mockito;

import com.training.dao.DAO;
import com.training.exceptions.DbInsertionFailedException;
import com.training.exceptions.InvalidDetailsException;
import com.training.models.Employee;
import com.training.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    DAO dao;

    EmployeeService employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeService();
        employeeService.setDb(dao);
    }

    @Test
    public void EmployeeAddedToDb() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pankil", "SDE 1");
        employeeService.setEmployee(employee);

        when(dao.insert(employee)).thenReturn(true);
        boolean res = employeeService.validateEmployeeDetails();
        assertTrue(res);
        verify(dao).insert(employee);
    }

    @Test
    public void EmployeeNotAddedToDb() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pankil", "SDE 1");
        employeeService.setEmployee(employee);

        when(dao.insert(employee)).thenReturn(false);
        boolean res = employeeService.validateEmployeeDetails();
        assertFalse(res);
        verify(dao).insert(employee);
    }

    @Test(expected = DbInsertionFailedException.class)
    public void EmployeeDbInsertionFailed() throws DbInsertionFailedException {
        Employee employee = new Employee(1, "Pankil", "SDE 1");
        employeeService.setEmployee(employee);

        when(dao.insert(employee)).thenThrow(DbInsertionFailedException.class);
        employeeService.addEmployee();
        verify(dao).insert(employee);
    }

    @Test(expected = InvalidDetailsException.class)
    public void EmployeeInvalidIdException() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(-1, "Pankil", "SDE 1");
        employeeService.setEmployee(employee);

        when(dao.insert(employee)).thenThrow(InvalidDetailsException.class);
        boolean res = employeeService.validateEmployeeDetails();
        verify(dao).insert(employee);
    }

    @Test(expected = InvalidDetailsException.class)
    public void EmployeeInvalidNameException() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pan", "SDE 1");
        employeeService.setEmployee(employee);

        when(dao.insert(employee)).thenThrow(InvalidDetailsException.class);
        boolean res = employeeService.validateEmployeeDetails();
        verify(dao).insert(employee);
    }

    @Test(expected = InvalidDetailsException.class)
    public void EmployeeInvalidIdAndNameException() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(-1, "Pan", "SDE 1");
        employeeService.setEmployee(employee);

        when(dao.insert(employee)).thenThrow(InvalidDetailsException.class);
        boolean res = employeeService.validateEmployeeDetails();
        verify(dao).insert(employee);
    }
}
