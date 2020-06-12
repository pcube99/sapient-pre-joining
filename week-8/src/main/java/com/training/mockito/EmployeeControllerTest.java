package com.training.mockito;

import com.training.controllers.EmployeeController;
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

public class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;

    private EmployeeController employeeController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        employeeController = new EmployeeController();
        employeeController.setEmployeeService(employeeService);

    }

    @Test
    public void EmployeeNameInvalid() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pan", "SDE 1");
        employeeController.setEmployee(employee);
        when(employeeService.validateEmployeeDetails()).thenReturn(false);
        boolean res = employeeController.addEmployeeInDb();
        assertFalse(res);
        verify(employeeService).validateEmployeeDetails();
    }

    @Test
    public void EmployeeIDInvalid() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(-1, "Pankil", "SDE 1");
        employeeController.setEmployee(employee);

        when(employeeService.validateEmployeeDetails()).thenReturn(false);
        boolean res = employeeController.addEmployeeInDb();
        assertFalse(res);
        verify(employeeService).validateEmployeeDetails();
    }

    @Test
    public void EmployeeWithValidInputs() throws DbInsertionFailedException, InvalidDetailsException {
        Employee employee = new Employee(1, "Pankil", "SDE 1");
        employeeController.setEmployee(employee);

        when(employeeService.validateEmployeeDetails()).thenReturn(true);
        boolean res = employeeController.addEmployeeInDb();
        assertTrue(res);
        verify(employeeService).validateEmployeeDetails();
    }
}
