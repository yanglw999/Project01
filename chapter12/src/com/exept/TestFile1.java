package com.exept;

import java.io.File;

public class TestFile1 {
    public static void main(String[] args) {
        File file1 = new File("E:\\Study_coding\\IDEA_workspace\\Image");
        File[] listFiles = file1.listFiles(); //listFiles() returns an array, list all files in the file folder
        for(File f : listFiles){
            if(f.isFile() && f.getName().endsWith(".jpg")){
                //System.out.println(f.getAbsolutePath());
                System.out.println(f.getName()); // relative name(file name)
            }
        }
    }
}
