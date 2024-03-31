package com.exept;

import java.io.File;
import java.io.IOException;

public class TestFile3 {
    public static void main(String[] args) throws IOException { // the IOException is necessary
        String path = "E:" + File.separator + "canada.png";
        File file = new File(path);
        if(file.exists())
            file.delete();
        file.createNewFile();
    }
}
