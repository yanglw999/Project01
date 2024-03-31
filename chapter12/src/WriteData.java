import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteData {
    public static void main(String[] args) throws IOException {
        File file = new File("windows.txt");
        if(file.exists()) {
            System.out.println("File is already there.");
            //System.exit(1);
        }else
        {file.createNewFile();}
        // write info into file using PrintWriter
        PrintWriter output = new PrintWriter(file);
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);
        output.print("hello java!");
        output.println("\nOn April 17, 2022");

        output.close();

    }
}
