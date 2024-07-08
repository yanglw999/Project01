package com.phonebook;

import java.util.Scanner;

public class TelNoteRegex {
    // local var will disappear with the method it lives done,
    // but member bar will live until the object dies,
    // local var uses less memory space because of short life
    public int menuItemValidate(int min, int max){
    String regex = "[0-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("please enter the right number, min: " + min +"\tmax: " + max);
            String input = scanner.nextLine();
            if(input.matches(regex)){
                int v = Integer.parseInt(input);
                if(v >= min && v <= max){
                    return v;
                }else {
                    System.out.println("the enter value is out of bound.");
                }

            }else {
                System.out.println("enter format is incorrect, please check!!");
            }
        }

    }
    public String nameValidate(){
        String regex = "[a-zA-Z]{1,10}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("please enter the name 10 alphabets max without numbers: ");
            String name = scanner.nextLine();
            if(name.matches(regex)){
                return name;
            }else {
                System.out.println("the name format is incorrect");
            }
        }


    }
    public String ageValidate(){
        String regex = "[1-9]{1}[0-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("input the person's age between 10 and 99: ");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                int age = Integer.valueOf(input);
                if(age >= 10 && age <= 99){

                    return age + " ";
                }else {
                    System.out.println("the age is out corridor!!");
                }
            }else{
                System.out.println("the age format is incorrect, please re-enter.");
            }
        }
    }
    public String genderValidate(){
        String regex = "[m|M|f|F]{1}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("please enter the gender female or male: ");
            char input =  scanner.next().charAt(0);
            String gender = Character.toString(input);
            if(gender.matches(regex)){
                return gender;
            }else {
                System.out.println("the enter of gender is incorrect.");
            }
        }
    }
    public String telNumValidate(){
        String regex = "(\\d{3,4}-\\d{7,8})|([0-9]{10,11})";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("please enter telephone or ceil phone #:");
            String num = scanner.nextLine();
            if(num.matches(regex)){
                return num;
            }else{
                System.out.println("the number is incorrect.");
            }
        }
    }
    public String addressValidate(){
        String regex = "\\w{1,50}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("enter the address");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("the address format is incorrect.");
            }
        }

    }


}
