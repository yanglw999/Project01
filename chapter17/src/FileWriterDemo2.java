import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterDemo2 {
    public static void main(String[] args) throws Exception {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        try (
                FileReader fileReader = new FileReader(path + "fileWriterDemo.txt");
                FileWriter fileWriter = new FileWriter(path + "fileWriterDemo2.txt");
                ) {
            int temp = 0;
            char [] buff = new char[1024];// cannot use fileReader.available to replace 1024
            while ((temp = fileReader.read(buff)) != -1){
                fileWriter.write(buff,0,temp);
            }
            fileWriter.flush();
        }
    }
}
