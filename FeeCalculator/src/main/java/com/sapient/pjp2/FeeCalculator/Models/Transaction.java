package com.sapient.pjp2.FeeCalculator.Models;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Transaction {
    private String externalTransactionId;
    private String clientId;
    private String securityId;
    private String transactionType;
    private String transactionDate;
    private double marketValue;
    private String priorityFlag;
    private long processingFee;

    // constructors

    public  Transaction() {

    }
    public Transaction(String externalTransactionId, String clientId,
                       String securityId, String transactionType,
                       String transactionDate, double marketValue,
                       String priorityFlag) {
        this.externalTransactionId = externalTransactionId;
        this.clientId = clientId;
        this.securityId = securityId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.marketValue = marketValue;
        this.priorityFlag = priorityFlag;
    }

    // getters and setters
    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public String getPriorityFlag() {
        return priorityFlag;
    }

    public void setPriorityFlag(String priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public long getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(long processingFee) {
        this.processingFee = processingFee;
    }
}
