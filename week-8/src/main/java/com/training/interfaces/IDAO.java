package com.training.interfaces;
import com.training.exceptions.DbInsertionFailedException;
import com.training.models.Employee;

public interface IDAO {
    boolean insert(Employee newEmployee) throws DbInsertionFailedException;
}
