import java.io.*;
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        String path = "E:\\Study_coding\\IDEA_workspace\\Project01\\chapter17\\src\\";
        try(
                RandomAccessFile raf = new RandomAccessFile(path + "raf.txt","rw");
                ){
            raf.setLength(0);
            int [] nums = {1,2,3,4,5,6,7,8,9,10};
            for(int num : nums){
                raf.writeInt(num);
            }
            raf.seek(3*4);// at the beginning of the 4th element position
            raf.writeInt(100); // write a new element in 4th position
            raf.seek(0);
            for(int num : nums){
                // raf.getFilePointer() returns the total bytes from the beginning of file to current location
                //.length returns the total bytes of file size
                if(raf.getFilePointer() < raf.length())
                    System.out.print(raf.readInt() + " ");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
