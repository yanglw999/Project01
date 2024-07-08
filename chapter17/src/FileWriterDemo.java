import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        try(
                java.io.FileWriter fileWriter = new java.io.FileWriter(path + "fileWriterDemo.txt");
                FileWriter fileWriter1 = new FileWriter(path + "fileWriterDemo.txt",true);
                ){
                fileWriter.write("May 21, 2024\r\n");
                fileWriter.flush();
                fileWriter1.write("i am studying Java at house.");
                fileWriter1.flush();
        }
    }
}
