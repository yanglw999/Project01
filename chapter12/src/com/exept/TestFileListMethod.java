package com.exept;

import java.io.File;

public class TestFileListMethod {
    public static void main(String[] args) {
        File f = new File("E:\\Study_coding\\IDEA_workspace\\Image");
        System.out.println("file name \t\t\t file type \t\t file size");
        System.out.println("==========================================");
        String [] fileList = f.list();
        for(int i = 0; i < fileList.length; i++) {
            System.out.print(fileList[i] + "\t\t\t");
            System.out.print(    (new File("E:\\Study_coding\\IDEA_workspace\\Image", fileList[i])).isFile()?     "file\t\t":"folder\t\t" ); //$$$

            System.out.print(    (new File("E:\\Study_coding\\IDEA_workspace\\Image", fileList[i])).length()      );

            System.out.println();
        }
    }
}
