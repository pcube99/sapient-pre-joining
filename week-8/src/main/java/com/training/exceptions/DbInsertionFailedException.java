package com.training.exceptions;

public class DbInsertionFailedException extends Throwable {
    public DbInsertionFailedException() {
        System.out.println("Not able to add employee to database");
    }
}
