import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FileUtilsDemo {
    public static void main(String[] args) throws IOException {
        String pathSrc = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        String PathDest = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\dest\\";
            // $$$ anonymous interface FileFilter is instantiated
        FileUtils.copyDirectory(new File(pathSrc), new File(PathDest), new FileFilter() {
                    @Override // accept() is re-defined to set filter rules
                    public boolean accept(File pathname) {
                        if (pathname.isDirectory() || pathname.getName().endsWith("jpg"))
                            return true;
                        return false;
                    }
                }
        );
    }
}
