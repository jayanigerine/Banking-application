package com.example.demo.model;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="transaction")
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="trans_id")
private int trans_id;
    @Column(name="trans_action")
private String trans_action;
    @Column(name="trans_date")
private Date trans_date;
    @Column(name="trans_amount")
private float amount;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name= "cusAccno")
private Customer customer;

    public Transaction(int trans_id, String trans_action, Date trans_date, float amount, Customer customer) {
        this.trans_id = trans_id;
        this.trans_action = trans_action;
        this.trans_date = trans_date;
        this.amount = amount;
        this.customer = customer;
    }



    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trans_id=" + trans_id +
                ", trans_action='" + trans_action + '\'' +
                ", trans_date=" + trans_date +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {
        this.trans_id = trans_id;
    }

    public String getTrans_action() {
        return trans_action;
    }

    public void setTrans_action(String trans_action) {
        this.trans_action = trans_action;
    }

    public Date getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(Date trans_date) {
        this.trans_date = trans_date;
    }

    public float getamount() {
        return amount;
    }

    public void setamount(float trans_amount) {
        this.amount = trans_amount;
    }
}
