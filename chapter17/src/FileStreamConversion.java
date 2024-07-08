import java.io.*;
public class FileStreamConversion {

    public static void FileCopy(String src, String dest){
        try(
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest)));
                ){
            String temp = "";
            int i = 1;
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
