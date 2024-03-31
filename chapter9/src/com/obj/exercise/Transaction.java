package com.obj.exercise;

import java.util.Date;

public class Transaction extends Account {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    public Transaction(){

    }
    public Transaction(char type,double amount,double balance,String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        date = new Date();
    }

}
