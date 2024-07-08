import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputDemo {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        // try-with-resource will close files automatically
        try (
                FileInputStream file = new FileInputStream(path + "Flag_canada.jpg");
                // it finally generate a picture file
                FileOutputStream out = new FileOutputStream(path + "BufferedOutputDemo.jpg");)
        {   // create a buffer zone
            byte [] buffer = new byte[1024];
            int temp = 0;
            while ((temp = file.read(buffer)) != -1){ // every time it reads 1024 bytes except last time
                out.write(buffer,0,temp); // buffer starts from 0 and ends with the length, that is temp
            }
            // write data to disk from memory
            out.flush();
        }
    }
}