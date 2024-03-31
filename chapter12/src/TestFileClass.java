import java.io.File;
import java.util.Date;

public class TestFileClass {
    public static void main(String[] args) {
        File file = new File("E:\\Study_coding\\IDEA_workspace\\Project01\\chapter12","hello.txt");
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println("does it exist: " + (file.exists()? "yes":"no"));
        System.out.println("the file has " + file.length() + " bytes.");
        System.out.println("can it be read? " + (file.canRead()? "yes":"no"));
        System.out.println("can it be written? " + file.canWrite());
        System.out.println("is it a directory? " + file.isDirectory());
        System.out.println("is it a file? " + file.isFile());
        System.out.println("is it absolute? " + file.isAbsolute());
        System.out.println("is it hidden? " + file.isHidden());
        System.out.println("absolute path is " + file.getAbsolutePath());
        System.out.println("last modified on " + new Date(file.lastModified()));
        File file1 = new File("E:\\Study_coding\\IDEA_workspace\\Image\\canada.png");
        System.out.println(file1.getAbsolutePath());
    }
}
