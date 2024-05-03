package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int bal_id;
    private float bal;
    private Date updated_date;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="cusAccno")
    private Customer customer;

    public Balance( float bal, Date updated_date, Customer customer) {
        this.bal = bal;
        this.updated_date = updated_date;
        this.customer = customer;
    }

    public Balance(float bal, Date updated_date) {

        this.bal = bal;
        this.updated_date = updated_date;
    }

    public Balance() {
    }

    @Override
    public String toString() {
        return "Balance{" +
                "bal_id=" + bal_id +
                ", bal=" + bal +
                ", updated_date=" + updated_date +
                ", customer=" + customer +
                '}';
    }

    public int getBal_id() {
        return bal_id;
    }

    public void setBal_id(int bal_id) {
        this.bal_id = bal_id;
    }

    public float getBal() {
        return bal;
    }

    public void setBal(float bal) {
        this.bal = bal;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
