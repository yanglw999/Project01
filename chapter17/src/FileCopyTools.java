import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTools {
    public static void main(String[] args) throws Exception {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        FileCopyTools.copyFile(path + "Flag_canada.jpg", path + "FileCopyTools.jpg");
    }
    public static void copyFile(String src, String dest)throws Exception{
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
                ){
            int temp = 0;
            while ((temp = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(temp);
            }
            bufferedOutputStream.flush();
        }
    }
}
