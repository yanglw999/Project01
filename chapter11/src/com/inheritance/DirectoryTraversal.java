package com.inheritance;

import java.io.File;

public class DirectoryTraversal  {
    public static void main(String[] args) {
        File file = new File("E:\\Study_coding\\IDEA_workspace\\Project01");
        printFile(file,0);
    }

    static void printFile(File file, int level){
        // print level
        for(int i = 0 ; i < level; i++){
            System.out.print("-");
        }
        // print the file name
        // filter the needed files
        if(file.isDirectory() || file.getName().toLowerCase().endsWith("java"))
            System.out.println(file.getName());
        if(file.isDirectory()){
            File [] files = file.listFiles();
            for(File f : files){
                printFile(f, level + 1);
            }
        }
    }
}
