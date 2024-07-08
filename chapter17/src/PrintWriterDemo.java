import java.io.*;

public class PrintWriterDemo {
    public static void FileCopy(String src, String dest) throws FileNotFoundException {

        try( // here outputStream is different from inputStream, so both can be independent
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
                PrintWriter printWriter = new PrintWriter(dest);
                ){
            String temp = "";
            int i = 1;
            while ((temp = bufferedReader.readLine()) != null){
                printWriter.println(i + ", " + temp);
                i++;
            }// printWriter does not need to call flush() explicitly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
