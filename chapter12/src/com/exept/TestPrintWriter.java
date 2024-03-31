package com.exept;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
    public static void main(String[] args) throws IOException { // IOException is necessary, or can not operate correctly
        File f = new File("E:\\Study_coding\\IDEA_workspace\\Image\\test2022.txt");
        if(f.exists()) {

            System.out.println(f.getAbsolutePath());
            PrintWriter output = new PrintWriter(f);
            output.print("oct 12, 2022");
            output.close(); // necessary, otherwise, it can not write in the file.
        }

    }
}
