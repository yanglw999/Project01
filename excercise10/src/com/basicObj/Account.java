package com.basicObj;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    double annualInterestRate;
    String name;
    private Date dateCreated;
    public Account (){
        dateCreated = new Date();
    }
    public Account (int id){
        this.id = id;
        balance = 100;
        dateCreated = new Date();
    }
    Account(String name ,int identity, double initialBalance){
        this.name = name;
        id = identity;
        balance = initialBalance;
        dateCreated = new Date();
    }
    public void setAnnualRate(double decimal){
        annualInterestRate = decimal / 100;
    }
    public Date setDate(long num){
        return dateCreated = new Date(num);
    }
    public int getID(){
        return this.id; // id cannot be referenced in a non-static
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public double getMonthlyIntRate(){
        return annualInterestRate / 12;
    }
    public void withdraw(double cash){
        balance -= cash;
    }
    public void deposit(double cash){
        balance = getBalance() + cash;
    }

}

