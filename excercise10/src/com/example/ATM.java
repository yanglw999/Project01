package com.example;

import com.basicObj.Account; // only can the packages under same module be imported

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Account[] clients = new Account[5];  // array object
        for(int i = 0; i < clients.length; i++){
            clients[i] = new Account(i);
        }

       while (true) {
           System.out.print("Enter an id: ");
           Scanner input = new Scanner(System.in);
           int identify = input.nextInt();

           int index = -1;
           for (int i = 0; i < clients.length; i++) {
               if (clients[i].getID() == identify) {
                   index = i;
                   String[] menu = {"Main menu choice: ", "1: check balance", "2: withdraw", "3: deposit", "4: exit"};
                   for (String str : menu) {
                       System.out.println(str);
                   }
               }
           }

           System.out.println("Enter a choice: ");
           Scanner menuInput = new Scanner(System.in);
           int choice = menuInput.nextInt();
           switch (choice) {

               case 1:
                   //System.out.println(String.format("the balance is %.2",clients[index].getBalance()));
                   System.out.println("the balance is " + clients[index].getBalance());
                   break;
               case 2:
                   System.out.print("Enter an amount to withdraw: ");
                   Scanner withdraw = new Scanner(System.in);
                   clients[index].withdraw(withdraw.nextDouble());
                   System.out.println("the balance is " + clients[index].getBalance());
                   break;
               case 3:
                   System.out.print("Enter an amount to deposit: ");
                   Scanner deposit = new Scanner(System.in);
                   double d = deposit.nextDouble();
                   clients[index].deposit(d);
                   System.out.println("the balance is " + clients[index].getBalance());
                   break;
               case 4:
                   System.out.println("the balance is " + clients[index].getBalance());
                   System.exit(0);
                   break;
           }

       }
        //System.out.println(String.format("the balance is %.2",clients[index].getBalance()));

    }
}
