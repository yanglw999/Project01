package com.exept;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadFileFromURL1 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        System.out.println("enter a URL: ");
        String strURL = input.nextLine();
        try {
            URL url = new URL(strURL);
            Scanner inputURL = new Scanner(url.openStream());
            int count = 0;
            while (inputURL.hasNext()){
                int line = inputURL.nextLine().length();
                count += line;
            }
            System.out.println("the file size is: " + count + "characters.");
        } catch (MalformedURLException ex){  // two 'catch' order can not be reversed
            System.out.println("invalid URL"); // first check if URL is valid, second, check the i/o
        }
        catch (IOException ex) {
            System.out.println("I/O errors: no such file.");
        }

    }
}
