package com.sapient.pjp2.FeeCalculator.Controllers;

import com.sapient.pjp2.FeeCalculator.Models.Transaction;
import com.sapient.pjp2.FeeCalculator.Services.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeeController {
    @Autowired
    FeeService feeService;

    @GetMapping(path = "/generate-report")
    public List<Transaction> generateReportUnsorted() {
        feeService.readExcelInput();
        feeService.generateFeeTransactions();
        List<Transaction> transactions= feeService.getTransactions();
        return transactions;
    }
}
