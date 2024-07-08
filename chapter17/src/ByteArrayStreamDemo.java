import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        byte[] src = "abcdef".getBytes();
        System.out.println(byteOutput(src));
    }
    public static String byteOutput(byte[] array){
        StringBuilder builder = new StringBuilder();
        try(
                ByteArrayInputStream in = new ByteArrayInputStream(array);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ){
            int temp = 0;
            while ((temp = in.read()) != -1){
                out.write(temp);
            }
            out.flush();
            byte [] dest = out.toByteArray();
            for(byte e : dest){
                builder.append((char) e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
