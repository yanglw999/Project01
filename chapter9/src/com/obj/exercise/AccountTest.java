package com.obj.exercise;

public class AccountTest {
    public static void main(String[] args) {
        Account owner = new Account("Geoge",1122,20000);
        owner.setAnnualRate(4.5);
        owner.withdraw(2500);
        owner.deposit(3000);
        owner.setDate(100000L); // .setTime();
        System.out.println("balance: " + owner.getBalance() + ";");
        System.out.printf("monthly int:%.2f ", owner.getMonthlyIntRate() * owner.getBalance());
        System.out.println("\nThe created date: " + owner.getDateCreated());
    }
}
