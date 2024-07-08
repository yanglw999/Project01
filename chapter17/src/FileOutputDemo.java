import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputDemo {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        // try-with-resource will close files automatically
        try (
             FileInputStream file = new FileInputStream(path + "Flag_canada.jpg");
             // it finally generate a picture file: fileOutputDemo.jpg
             FileOutputStream out = new FileOutputStream(path + "fileOutputDemo.jpg");)
        {
            int temp = -2;

            while ((temp = file.read()) != -1){
                out.write(temp);
            }
            // write data to disk from memory
            out.flush();
        }
    }
}
