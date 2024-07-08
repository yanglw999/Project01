import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try{
            fileInputStream = new FileInputStream(path + "Flag_canada.jpg");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(path + "BufferedOutputStreamDemo.jpg");
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            int temp = -1;
            while((temp = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(temp);
            }
            bufferedOutputStream.flush();
        }catch(Exception e){

        }finally {
            try{
                // order to close the stream: open last but close first
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
                if(fileInputStream != null)
                    fileInputStream.close();
                if(bufferedOutputStream != null)
                    bufferedOutputStream.close();
                if(fileOutputStream != null)
                    fileOutputStream.close();

            }catch (Exception ex){

            }
        }
    }
}
