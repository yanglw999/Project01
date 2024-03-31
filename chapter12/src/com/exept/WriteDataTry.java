package com.exept;

import java.io.File;
import java.io.PrintWriter;

public class WriteDataTry {
    public static void main(String[] args) throws Exception {
        File f = new File("windows.txt");
        if(f.exists()){
            System.out.println(f.getAbsolutePath());
            System.out.println(f.length() + " bytes.");
        }else
        {
            f.createNewFile();
        }
        try(PrintWriter output = new PrintWriter(f);) {
            output.println(23);
            output.printf("new file with num %.2f", 23.0);
        }
    }
}
