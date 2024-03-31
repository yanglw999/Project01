package com.exept;

import java.io.File;
import java.io.IOException;

public class TestFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Study_coding\\IDEA_workspace\\Image","canada.png");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();// will create a file with same deleted file name
    }
}
