import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadFileFromURL {
    public static void main(String[] args) {
        System.out.print("enter a URL: ");
        Scanner input = new Scanner(System.in);
        String URLStr = input.next();
        try{
            URL url = new URL(URLStr);
            int count = 0;
            Scanner URLInput = new Scanner(url.openStream());
            while (URLInput.hasNext()){
                String line =  URLInput.nextLine();
                int len = line.length();
                count += len;
            }
            System.out.println("the file size is: " + count + " characters.");
        }
        catch (MalformedURLException ex){
            System.out.println("Invalid URL");
        }
        catch (IOException ex){
            System.out.println("I/O Errors: no such file");
        }
    }
}
