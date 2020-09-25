package com.sapient.pjp;
import com.sapient.pjp.models.DateCalculator;
import com.sapient.pjp.services.DateCalculatorService;
import java.time.LocalDate;
import java.util.Scanner;

public class DateCalculatorRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateInput1, dateInput2;
        LocalDate date1, date2, date = null;
        int numberOfDays, numberOfChoice;

        // scanning the input
        System.out.println("Welcome To Date Calculator");
        System.out.println("Enter Date 1 in the format dd-MM-yyyy: ");
        dateInput1 = scanner.next();
        System.out.println("Enter Date 2 in the format dd-MM-yyyy: ");
        dateInput2 = scanner.next();

        // creating new instances for model and services
        DateCalculator dateTimeCalculator = new DateCalculator();
        DateCalculatorService dateCalculatorService = new DateCalculatorService(dateTimeCalculator);

        // we need date in local format, so convert string to local format
        date1 = dateCalculatorService.getNaturalDate(dateInput1);
        if(date1 == null) {
            date1 = dateCalculatorService.convertToDate(dateInput1);
        }
        System.out.println("Date 1: " + date1);

        date2 = dateCalculatorService.getNaturalDate(dateInput2);
        if(date2 == null) {
            date2 = dateCalculatorService.convertToDate(dateInput2);
        }
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
                    // add two dates
                    dateCalculatorService.addTwoDates();
                    break;
                case 2:
                    // substract two dates
                    dateCalculatorService.subtractTwoDates();
                    break;

                case 3:
                    // add days to given date
                    System.out.println("Enter Date in the format dd-MM-yyyy");
                    dateInput1 = scanner.next();

                    System.out.println("Enter the number of days you want to add");
                    numberOfDays = scanner.nextInt();
                    Boolean flag = true;
                    date = dateCalculatorService.getNaturalDate(dateInput1);
                    if(date == null) {
                        date = dateCalculatorService.convertToDate(dateInput1);
                    }
                    dateCalculatorService.addDaysToDate(date, numberOfDays);
                    break;
                case 4:
                    // substract days from given date
                    System.out.println("Enter Date in the format dd-MM-yyyy: ");
                    dateInput1 = scanner.next();

                    date = dateCalculatorService.convertToDate(dateInput1);
                    System.out.println("Enter the number of days you want to subtract:");
                    numberOfDays = scanner.nextInt();
                    dateCalculatorService.subtractDays(date, numberOfDays);
                    break;
                case 5:
                    // find day of week
                    System.out.println("Enter Date in the format dd-MM-yyyy: ");
                    dateInput1 = scanner.next();
                    date = dateCalculatorService.convertToDate(dateInput1);
                    dateCalculatorService.findDayOfGivenDate(date);
                    break;
                case 6:
                    // find which day on given date
                    System.out.println("Enter Date in the format dd-MM-yyyy: ");
                    dateInput1 = scanner.next();
                    date = dateCalculatorService.convertToDate(dateInput1);
                    dateCalculatorService.findWeekNumberOfGivenDate(date);
                    break;

                default:
                    System.out.println("Please enter number as mentioned above.");
            }
        } while (numberOfChoice != 6);
        scanner.close();
    }
}
