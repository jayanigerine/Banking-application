package com.example.demo.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "cus_accno")
    private String cusAccno;

    @Column(name = "cus_name")
    private String cus_name;
    @Column(name = "cus_add")
    private String cus_add;

    @OneToOne(mappedBy = "customer")
    private Balance balance;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transaction;

//    @Override
//    public String toString() {
//        return "Customer{" +
//                ", cusAccno='" + cusAccno + '\'' +
//                ", cus_name='" + cus_name + '\'' +
//                ", cus_add='" + cus_add + '\'' +
//                ", balance=" + balance +
//                ", transaction=" + transaction +
//                '}';
//    }

    public String getCusAccno() {
        return cusAccno;
    }


    public Customer(String cusAccno, String cus_name, String cus_add, Balance balance, List<Transaction> transaction) {
        this.cusAccno = cusAccno;
        this.cus_name = cus_name;
        this.cus_add = cus_add;
        this.balance = balance;
        this.transaction = transaction;
    }

    public Customer(String cus_name, String cus_add) {

        this.cus_name = cus_name;
        this.cus_add = cus_add;

    }

    public Customer() {
    }

    public void setCusAccno(String cusAccno) {
        this.cusAccno = cusAccno;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_add() {
        return cus_add;
    }

    public void setCus_add(String cus_add) {
        this.cus_add = cus_add;
    }

}
