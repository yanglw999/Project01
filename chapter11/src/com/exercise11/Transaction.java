package com.exercise11;

import java.util.Date;

public class Transaction {
   private Date date;
   private char ch;
   private double amount;
   private String description;
   private double balanceAfterTransaction;


    public  Transaction(){

    }
 public Transaction (char ch, double amount, String description){
        date = new Date();
        this.ch = ch;
        this.amount = amount;
        this.description = description;
        //setBalanceAfterTransaction();

    }
    public String DepositOrWithdraw(){
        return ch == 'D'? " + " : " - ";
    }
    public Date getDate(){
        return date;
    }
    public double getAmount(){
        return amount;
    }
    public char getCh(){
        return ch;
    }
  /* public void setBalanceAfterTransaction(){
        balanceAfterTransaction = ((Account)transaction).getBalance();
   }
*/

    @Override
    public String toString(){
        return DepositOrWithdraw() + " $" + amount + ", for " + description + ", " + " on "+ getDate();
    }

}
