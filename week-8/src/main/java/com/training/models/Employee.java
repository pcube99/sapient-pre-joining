package com.training.models;

public class Employee {
    private int empId;
    private String empName;
    private String empPosition;

    public Employee(int empId, String empName, String empPosition) {
        this.empId = empId;
        this.empName = empName;
        this.empPosition = empPosition;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPosition='" + empPosition + '\'' +
                '}';
    }
}
