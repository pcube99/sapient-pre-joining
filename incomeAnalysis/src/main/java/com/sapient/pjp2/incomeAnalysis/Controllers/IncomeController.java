package com.sapient.pjp2.incomeAnalysis.Controllers;

import com.codoid.products.exception.FilloException;
import com.sapient.pjp2.incomeAnalysis.Models.Income;
import com.sapient.pjp2.incomeAnalysis.Services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @GetMapping("average-income")
    public List<Income> findAverage() throws FilloException, IOException {
        List<Income> incomeList = new ArrayList<Income>();

        // adding the input countries and gender to list
        incomeList.add(incomeService.findAverageIncome("INR", "F"));
        incomeList.add(incomeService.findAverageIncome("INR", "M"));
        incomeList.add(incomeService.findAverageIncome("GBP", "F"));
        incomeList.add(incomeService.findAverageIncome("GBP", "M"));
        incomeList.add(incomeService.findAverageIncome("HKD", "F"));
        incomeList.add(incomeService.findAverageIncome("HKD", "M"));
        incomeList.add(incomeService.findAverageIncome("SGP", "F"));
        incomeList.add(incomeService.findAverageIncome("SGP", "M"));
        incomeList.add(incomeService.findAverageIncome("USD", "F"));
        incomeList.add(incomeService.findAverageIncome("USD", "M"));
        incomeService.writeExcel(incomeList, "src/main/resources/static/output.xlsx");
        return incomeList;
    }
}
