package com.training.dao;

import com.training.exceptions.DbInsertionFailedException;
import com.training.interfaces.IDAO;
import com.training.models.Employee;

public class DAO implements IDAO {

    @Override
    public boolean insert(Employee newEmployee) throws DbInsertionFailedException {
        System.out.println("Employee has been successfully added to db.");
        return true;
    }
}
