package com.exept;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\Study_coding\\IDEA_workspace\\Image","test2023.txt");
        Scanner input = new Scanner(f);
        if(f.exists()){
            while(input.hasNext()){
                String name = input.next();
                String age = input.next();
                String gender = input.next();
                String job = input.next();
                System.out.printf( "%-5s\t%-5s\t" + "%-5s\t"+ "%-5s\t\n", name, age, gender,job);
            }
        }
        input.close();

    }
}
