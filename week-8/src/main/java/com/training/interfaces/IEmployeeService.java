package com.training.interfaces;

import com.training.exceptions.DbInsertionFailedException;
import com.training.exceptions.InvalidDetailsException;

public interface IEmployeeService {

    // validate employee details
    public boolean validateEmployeeDetails() throws InvalidDetailsException, DbInsertionFailedException;

    // adds employee to database
    public boolean addEmployee() throws DbInsertionFailedException;
}
