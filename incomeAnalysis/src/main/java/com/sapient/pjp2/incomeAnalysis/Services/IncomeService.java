package com.sapient.pjp2.incomeAnalysis.Services;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.sapient.pjp2.incomeAnalysis.Models.Income;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class IncomeService {

    // open a connection to excel table and execute query
    public Recordset executeOnExcelFile(String q) throws FilloException {
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection("src/main/resources/static/input.xlsx");
        Recordset recordset = connection.executeQuery(q);
        return recordset;
    }

    // find average income
    public Income findAverageIncome(String currency, String gender) throws FilloException {
        int c = 0;
        float sum = 0;
        String q = "select * from Sample_Input where Currency='" + currency + "' and Gender='" + gender + "'";
        Recordset recordset = executeOnExcelFile(q);
        while(recordset.next()) {
            sum += Float.parseFloat(recordset.getField("Average_Income"));
            c++;
        }
        float averageIncome = sum/c;

        // USD to respective country currency
        if (currency == "INR") {
            averageIncome /= 66 ;
        } else if (currency == "GBP") {
            averageIncome /= 0.67;
        } else if (currency == "SGP") {
            averageIncome /= 1.5;
        } else if (currency == "HKD") {
            averageIncome /= 8;
        }
        return new Income(averageIncome, currency, gender);
    }
    public void writeExcel(List<Income> incomeList, String excelFilePath) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (Income income : incomeList) {
            Row row = sheet.createRow(++rowCount);
            writeBook(income, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeBook(Income income, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(income.getCountry());

        cell = row.createCell(2);
        cell.setCellValue(income.getGender());

        cell = row.createCell(3);
        cell.setCellValue(income.getAvgIncome());
    }
}
