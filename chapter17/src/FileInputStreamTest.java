import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        try { // fix compiler exception either by throws or by try-catch
            String filePath = "E:\\Study_coding\\IDEA_workspace\\"
            + "Project01\\chapter17\\src\\InputTest.txt";
            file = new FileInputStream(filePath);
            //read() reads each character every time and return its ASCii code (int)
            // if reads nothing, return -1
            /*while(file.read() != -1){
                System.out.println(file.read());
            }*/ // above while() is not applicable here

            StringBuilder builder = new StringBuilder();
            int temp = -2;
            while((temp = file.read()) != -1){
                System.out.print(temp);
                System.out.println(" -> " + ((char)(temp)));
                builder.append((char)temp);
            }
            System.out.println(builder);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            file.close();


        }
    }
}
