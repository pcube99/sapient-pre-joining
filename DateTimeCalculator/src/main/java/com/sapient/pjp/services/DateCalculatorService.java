package com.sapient.pjp.services;

import com.sapient.pjp.models.DateCalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

public class DateCalculatorService {
    DateCalculator dateCalculator;
    public DateCalculatorService(DateCalculator calculator) {
        dateCalculator = calculator;
    }

    // change localdate to string, using for printing only
    public String changeDateFormat(LocalDate date) {
        String validConvertedDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            validConvertedDate = date.format(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validConvertedDate;
    }
    // string to date
    public LocalDate convertToDate(String date) {
        LocalDate validConvertedDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            validConvertedDate = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validConvertedDate;
    }

    // handles natural language phrases
    public LocalDate getNaturalDate(String i) {
        LocalDate localDate = LocalDate.now();

        if(i.equalsIgnoreCase("TODAY")) {
            return convertToDate(changeDateFormat(localDate));
        } else if(i.equalsIgnoreCase("YESTERDAY")) {
            localDate = localDate.minusDays(1);
            return convertToDate(changeDateFormat(localDate));
        } else if(i.equalsIgnoreCase("TOMORROW")) {
            localDate = localDate.plusDays(1);
            System.out.println("tom" + localDate);
            return convertToDate(changeDateFormat(localDate));
        } else if(i.equalsIgnoreCase("DAYAFTERTOMORROW")) {
            localDate = localDate.plusDays(2);
            return convertToDate(changeDateFormat(localDate).toString());
        } else if(i.equalsIgnoreCase("DAYBEFOREYESTERDAY")) {
            localDate = localDate.minusDays(2);
            return convertToDate(changeDateFormat(localDate).toString());
        }
        return null;
    }

    // add days to a given date
    public void addDaysToDate(LocalDate date, int days) {
        LocalDate answerDate;
        answerDate = date.plusDays(days);
        System.out.println(changeDateFormat(date) + " + " + days + " is "+ changeDateFormat(answerDate));
    }

    // substract days from a given date
    public void subtractDays(LocalDate date, int days) {
        LocalDate answerDate;
        answerDate = date.minusDays(days);
        System.out.println(changeDateFormat(date) + " - " + days + " is "+ changeDateFormat(answerDate));
    }

    // add two dates
    public void addTwoDates() {
        LocalDate answerDate = dateCalculator.getDate1();
        answerDate = answerDate.plusDays(dateCalculator.getDate2().getDayOfMonth());
        answerDate = answerDate.plusMonths(dateCalculator.getDate2().getMonthValue());
//        answerDate = answerDate.plusYears(dateCalculator.getDate2().getYear());
        System.out.println("Result of " + changeDateFormat(dateCalculator.getDate1()) + " + " +
                changeDateFormat(dateCalculator.getDate2()) + " is " + changeDateFormat(answerDate));
    }

    // subtract two dates
    public void subtractTwoDates() {
        LocalDate answerDate = dateCalculator.getDate1();
        answerDate = answerDate.minusDays(dateCalculator.getDate2().getDayOfMonth());
        answerDate = answerDate.minusMonths(dateCalculator.getDate2().getMonthValue());
//        answerDate = answerDate.minusYears(dateCalculator.getDate2().getYear());
        System.out.println("Result of " + changeDateFormat(dateCalculator.getDate1()) + " - " +
                changeDateFormat(dateCalculator.getDate2()) + " is " + changeDateFormat(answerDate));
    }

    // find day of week on a given date
    public void findDayOfGivenDate(LocalDate date) {
        System.out.println("Day Of The Week is " + date.getDayOfWeek());
    }

    // get week number based on given date
    public void findWeekNumberOfGivenDate(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
        System.out.println("Week Number is "+ weekNumber);
    }
}
