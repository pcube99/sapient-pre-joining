package com.sapient.pjp;

import java.time.LocalDate;
import java.util.Scanner;

public class DateCalculatorRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateInput1, dateInput2;
        LocalDate date1, date2;
        int numberOfDays, numberOfChoice;
        LocalDate date = null;

        System.out.println("Welcome To Date Calculator");

        System.out.println("Enter Date 1 in the format yyyy-MM-dd: ");
        dateInput1 = scanner.next();
        System.out.println("Enter Date 2 in the format yyyy-MM-dd: ");
        dateInput2 = scanner.next();
        DateCalculator dateTimeCalculator = new DateCalculator();
        date1 = dateTimeCalculator.convertToDate(dateInput1);
        System.out.println("Date 1: " + date1);
        date2 = dateTimeCalculator.convertToDate(dateInput2);
        System.out.println("Date 2: " + date2);
        dateTimeCalculator.setDate1(date1);
        dateTimeCalculator.setDate2(date2);
        do {
            System.out.println("Welcome To Date Calculator");
            System.out.println("1. Add two dates");
            System.out.println("2. Subtract two dates");
            System.out.println("3. Add days to a given date");
            System.out.println("4. Subtract days from a given date");
            System.out.println("5. Find day of week");
            System.out.println("6. Find Week Number of given date");
            System.out.println("Any other input to close the program");
            System.out.println("Please Enter Your Choice:");
            numberOfChoice = scanner.nextInt();
            switch (numberOfChoice) {
                case 1:
                    dateTimeCalculator.addTwoDates();
                    break;
                case 2:
                    dateTimeCalculator.subtractTwoDates();
                    break;
                case 3:
                    System.out.println("Enter Date in the format yyyy-MM-dd");
                    dateInput1 = scanner.next();
                    date = dateTimeCalculator.convertToDate(dateInput1);
                    System.out.println("Enter the number of days you want to add");
                    numberOfDays = scanner.nextInt();
                    dateTimeCalculator.addDaysToDate(date, numberOfDays);
                    break;
                case 4:
                    System.out.println("Enter Date in the format yyyy-MM-dd: ");
                    dateInput1 = scanner.next();
                    date = dateTimeCalculator.convertToDate(dateInput1);
                    System.out.println("Enter the number of days you want to subtract:");
                    numberOfDays = scanner.nextInt();
                    dateTimeCalculator.subtractDays(date, numberOfDays);
                    break;
                case 5:
                    System.out.println("Enter Date in the format yyyy-MM-dd: ");
                    dateInput1 = scanner.next();
                    date = dateTimeCalculator.convertToDate(dateInput1);
                    dateTimeCalculator.findDayOfGivenDate(date);
                    break;
                case 6:
                    System.out.println("Enter Date in the format yyyy-MM-dd: ");
                    dateInput1 = scanner.next();
                    date = dateTimeCalculator.convertToDate(dateInput1);
                    dateTimeCalculator.findWeekNumberOfGivenDate(date);
                    break;

                default:
                    System.out.println("Please enter number as mentioned above.");
            }
        } while (numberOfChoice != 6);
        scanner.close();
    }
}
