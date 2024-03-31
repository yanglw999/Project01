package com.exept;

import java.io.File;
import java.io.FilenameFilter;

public class ImageFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name){
        return name.endsWith("jpg") || name.endsWith("png");
    }


    public static void main(String[] args) {
        File f = new File("E:\\Study_coding\\IDEA_workspace\\Image");
        String list [] = f.list(new ImageFilter());
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + "\t\t\t");
            System.out.println((new File("E:\\Study_coding\\IDEA_workspace\\Image",list[i])).length());
        }
    }
}
