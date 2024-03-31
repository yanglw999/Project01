package com.exept;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) throws Exception {
        if(args.length!=4){
            System.out.println("usage: Java ClassName sourceFile targetFile oldString newString");
            System.exit(1);
        }
        //create the new File object
        File sourceFile = new File(args[0]);
        if(!sourceFile.exists()){
            System.out.println("sourceFile does not exist.");
        }
        File targetFile = new File(args[1]);
        if(targetFile.exists()){
            System.out.println("target has existed.");
        }
        try(Scanner input = new Scanner(sourceFile);
            PrintWriter output = new PrintWriter(targetFile)){
            while (input.hasNext()){
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2],args[3]);
                output.print(s2);
            }
        }
    }
}
