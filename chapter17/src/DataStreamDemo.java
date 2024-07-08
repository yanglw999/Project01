import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        dataOutputStream(path + "dataOutputStream.txt");
        dataInputStream(path + "dataOutputStream.txt");
    }
    public static void dataOutputStream(String dest){// generate a encoded file
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
                ){
            out.writeChar('a');
            out.writeInt(2);
            out.writeUTF("Tuesday");
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void dataInputStream(String src){
        try(
                DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(src)));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                ){// the read order must be consistent with write order
            bw.write(in.readChar() + "\n");
            bw.write(in.readInt() + "\n");
            bw.write(in.readUTF() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
