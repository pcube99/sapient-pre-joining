package com.training.exceptions;

public class InvalidDetailsException extends Throwable {
    public InvalidDetailsException(String empName, int empId) {
        System.out.println("Employee Details are invaild, employee name: " + empName
                + "is less than 4 letters and employee id: " + empId + " is negative. \n");
    }

    public InvalidDetailsException(String empName) {
        System.out.println("Employee Name: " + empName + " is must be greater than 4 characters. \n");
    }

    public InvalidDetailsException(int empId) {
        System.out.println("Employee Id: " + empId +" is invalid, must be positive. \n");
    }
}
