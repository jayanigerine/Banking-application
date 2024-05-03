package com.example.demo.model.dto;

import org.springframework.stereotype.Component;

@Component
public class Form2DTO {
    private String cusAccno;
    private String cusName;
    private Float balance;
    private Float amount;

    public String getCusAccno() {
        return cusAccno;
    }

    public void setCusAccno(String cusAccno) {
        this.cusAccno = cusAccno;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Form2DTO(String cusAccno, String cusName, float balance, float amount) {
        this.cusAccno = cusAccno;
        this.cusName = cusName;
        this.balance = balance;
        this.amount = amount;
    }

    public Form2DTO() {
    }
}
