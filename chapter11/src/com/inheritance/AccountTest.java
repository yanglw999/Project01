package com.inheritance;

import com.exercise11.Transaction;

public class AccountTest {
    public static void main(String[] args) {
        Account client1 = new Account("Bob",12,1000);
        System.out.println(client1.toString());
        System.out.println("the account statement as below: ");
        client1.setTransactions(new Transaction('D',30,"deposit"));
        client1.setTransactions(new Transaction('D',40,"deposit"));
        client1.setTransactions(new Transaction('W',50,"withdraw"));
        client1.setTransactions(new Transaction('W',5,"withdraw"));
        for(Transaction i : client1.transactions){
            System.out.println(i.toString());
        }
        System.out.println("the balance is: " + client1.balance);
    }
}
