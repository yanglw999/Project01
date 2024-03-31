package com.exept;

import java.io.File;

public class VisitFileFolder {
    public static void main(String[] args) {
        File f = new File("C:/");
        System.out.println("File Name:\t\t File Type:\t\t File Size");
        System.out.println("=========================================");
        String[]fileList = f.list();
        for(int i = 0; i < fileList.length; i++){
            System.out.print(fileList[i] + "\t\t");
            System.out.print((new File(fileList[i])).isFile()? "File" : "Folder" + "\t\t");
            System.out.println((new File(fileList[i])).length() + " bytes");
        }
    }
}
