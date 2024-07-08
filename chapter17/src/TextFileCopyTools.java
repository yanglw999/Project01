import java.io.*;
public class TextFileCopyTools {
    public static void main(String[] args) {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        textFileCopy(path + "fileWriterDemo.txt", path+ "TextFileCopyTools.txt");
    }
    public static void textFileCopy(String src, String dest){
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest));
                ){
            int i = 1; // add line number
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null){
                bufferedWriter.write(i + ", " + temp);
                bufferedWriter.newLine();
                i++;
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
