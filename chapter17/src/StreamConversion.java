import java.io.*;
public class StreamConversion {
    public static void main(String[] args) {
        try(
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
                ){
            String temp = "";
            while (true){
                bufferedWriter.write("please enter: ");
                bufferedWriter.flush();
                temp = bufferedReader.readLine();
                if(temp.equals("exit"))
                    break;
                bufferedWriter.write("your content: ");
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
