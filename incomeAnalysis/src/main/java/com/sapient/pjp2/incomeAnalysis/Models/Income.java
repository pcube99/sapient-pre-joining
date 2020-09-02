package com.sapient.pjp2.incomeAnalysis.Models;

public class Income {
    private float avgIncome;
    private String country, gender;

    private Income() {

    }

    public Income(float avgIncome, String country, String gender) {
        this.avgIncome = avgIncome;
        this.country = country;
        this.gender = gender;
    }

    // getters and setters
    public float getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(float avgIncome) {
        this.avgIncome = avgIncome;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
