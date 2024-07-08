import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputOnceDemo {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        // try-with-resource will close files automatically
        try (
                FileInputStream file = new FileInputStream(path + "Flag_canada.jpg");
                // it finally generate a picture file: fileOutputDemo.jpg
                FileOutputStream out = new FileOutputStream(path + "BufferedOutputOnceDemo.jpg");)
        {
            int temp = 0;
            // create a buffer zone as large as the size of file
            byte [] buffer = new byte[file.available()];
            file.read(buffer);
            //  it reads all bytes from the file once and writes it into memo once, so no while() loop
            // but if file is too large, it will use large share of memory, this way is not recommended
            out.write(buffer);
            // write data to disk from memory
            out.flush();
        }
    }
}
