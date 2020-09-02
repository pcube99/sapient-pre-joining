package com.sapient.pjp2.calculator.Models;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int ans;
    String operator;
    int number1;
    int number2;

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "id=" + id +
                ", ans=" + ans +
                ", operator='" + operator + '\'' +
                ", number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }
}
