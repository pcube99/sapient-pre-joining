package com.sapient.pjp2.FeeCalculator.Services;

import com.sapient.pjp2.FeeCalculator.Models.Transaction;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeeService {
    List<Transaction> transactions 	= new ArrayList<Transaction>();
    ;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // this function will read input from file and returns a List<Transaction>
    public void readExcelInput() {
        String csvFile = "src/main/resources/static/Sample_Data_Fee_Calculator.csv";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine();
            System.out.println("hello");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] data = line.split(",");
                String externalTransactionId = data[0];
                String clientId = data[1];
                String securityId = data[2];
                String transactionType = data[3];
                String transactionDate = data[4];
                double marketValue = Double.valueOf(data[5]);
                String priorityFlag = data[6];
                Transaction tr = new Transaction(externalTransactionId, clientId, securityId,
                        transactionType, transactionDate, marketValue, priorityFlag);
                transactions.add(tr);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // this function will calculate the transactions depending on weather
    // it is intra day or normal transaction
    public void generateFeeTransactions() {
        // Normal transaction
        normalTransactions();

        // Intra day transactions
        intraDayTransactions();
    }

    // this function will calculate the normal transaction fees according to given data
    private void normalTransactions() {
        long transactionFee;
        for (Transaction transaction : transactions) {
            if (transaction.getPriorityFlag().equals("Y")) {
                transactionFee = transaction.getProcessingFee();
                transaction.setProcessingFee(transactionFee + 500);
            } else if (transaction.getPriorityFlag().equals("N")) {
                String transactionType = transaction.getTransactionType();
                if (transactionType.equals("SELL") || transactionType.equals("WITHDRAW")) {
                    transactionFee = transaction.getProcessingFee();
                    transaction.setProcessingFee(transactionFee + 100);
                }
                if (transactionType.equals("BUY") || transactionType.equals("DEPOSIT")) {
                    transactionFee = transaction.getProcessingFee();
                    transaction.setProcessingFee(transactionFee + 50);
                }

            }
        }
    }

    // this function will calculate the intra day transaction fees
    private void intraDayTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            String firstClientId = transactions.get(i).getClientId();
            String firstSecurityId = transactions.get(i).getSecurityId();
            String firstTransactionDate = transactions.get(i).getTransactionDate();
            String firstTransactionType = transactions.get(i).getTransactionType();

            for (int j = i + 1; j < transactions.size(); j++) {
                String secondClientId = transactions.get(j).getClientId();
                String secondSecurityId = transactions.get(j).getSecurityId();
                String secondTransactionDate = transactions.get(j).getTransactionDate();
                String secondTransactionType = transactions.get(j).getTransactionType();
                if (firstClientId.equals(secondClientId) && firstSecurityId.equals(secondSecurityId) && firstTransactionDate.equals(secondTransactionDate)) {
                    if (firstTransactionType.equals("BUY") && secondTransactionType.equals("SELL") ||
                            firstTransactionType.equals("SELL") && secondTransactionType.equals("BUY") ||
                            firstTransactionType.equals("DEPOSIT") && secondTransactionType.equals("WITHDRAW") ||
                            firstTransactionType.equals("DEPOSIT") && secondTransactionType.equals("WITHDRAW")) {
                        long fee1 = transactions.get(i).getProcessingFee();
                        long fee2 = transactions.get(j).getProcessingFee();
                        transactions.get(i).setProcessingFee(fee1 + 10);
                        transactions.get(j).setProcessingFee(fee2 + 10);
                    }
                }
            }
        }
    }
}

