package com.inheritance;

import com.exercise11.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class Account extends Transaction {
    String name;
    int id;
    double balance;
    Date dateCreated;
    ArrayList<Transaction> transactions ;
    public Account(){
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }
    public Account(String name, int id, double initialBalance){
        dateCreated = new Date();
        this.name = name;
        this.id = id;
        this.balance = initialBalance;
        transactions = new ArrayList<>();
    }
    public void setTransactions(Transaction transaction){
        transactions.add(transaction);
        setBalance(transaction);
    }
    public void setBalance(Transaction transaction){
        if(transaction.getCh() == 'D'){
            balance += transaction.getAmount();
        }else {
            balance -= transaction.getAmount();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String toString(){
        return "the account was created on " + dateCreated + "\nID: " + id + " name: " + name + " initial deposit: " + balance;
    }
}
