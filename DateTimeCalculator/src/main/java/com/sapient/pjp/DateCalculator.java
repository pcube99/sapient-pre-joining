package com.sapient.pjp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateCalculator {
    LocalDate date1, date2;

    public DateCalculator() {

    }
    public DateCalculator(LocalDate date1, LocalDate date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(LocalDate date2) {
        this.date2 = date2;
    }

    // string to date
    public LocalDate convertToDate(String date) {
        LocalDate validConvertedDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            validConvertedDate = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validConvertedDate;
    }

    // add two dates
    public void addTwoDates() {
        LocalDate answerDate = date1;
        answerDate = answerDate.plusDays(date2.getDayOfMonth());
        answerDate = answerDate.plusMonths(date2.getMonthValue());
        answerDate = answerDate.plusYears(date2.getYear());
        System.out.println("Result of " + date1 + " + " + date2 + " is ");
        System.out.println("Date " + answerDate);
    }

    // subtract two dates
    public void subtractTwoDates() {
        LocalDate answerDate = date1;
        answerDate = answerDate.minusDays(date2.getDayOfMonth());
        answerDate = answerDate.minusMonths(date2.getMonthValue());
        answerDate = answerDate.minusYears(date2.getYear());
        System.out.println("Result of " + date1 + " - " + date2 + " is ");
        System.out.println("Date " + answerDate);
    }

    // add days to a given date
    public void addDaysToDate(LocalDate date, int days) {
        LocalDate answerDate;
        answerDate = date.plusDays(days);
        System.out.println(date + " + " + days + " is "+ answerDate);
    }

    // substract days from a given date
    public void subtractDays(LocalDate date, int days) {
        LocalDate answerDate;
        answerDate = date.minusDays(days);
        System.out.println(date + " - " + days + " is "+ answerDate);
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
