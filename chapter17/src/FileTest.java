import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\Study_coding\\IDEA_workspace\\"
                + "Project01\\chapter17\\src\\fileTest.txt";
        File file = new File(filePath);
        System.out.println(file.createNewFile());
        System.out.println("path: " + file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getParentFile().getName());
        File fileSrc = new File("E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17");
        String [] list = fileSrc.list();
        for(String e : list){
            System.out.print(e + "\t\t");
            System.out.println(new File(e).isDirectory()? "Folder" : "File");
        }
        // listFile return the objects of File
        File [] listFile = fileSrc.listFiles();
        for(File e : listFile){
            System.out.println(e);
        }
    }
}
