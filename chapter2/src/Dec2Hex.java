import java.util.Scanner;

public class Dec2Hex {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("enter a integer");
        int dec = input.nextInt();
        String hex =" ";
        char hexDigit;
        while(dec != 0){    //
           int  hexV =  dec % 16;
           if(hexV >= 10){
                hexDigit = (char)(hexV - 10 + 'A');
           }else{
               hexDigit = (char)(hexV - 0 + '0');
           }
           hex = hexDigit + hex;   // from right to left
           dec = dec / 16;
        }
        System.out.println("hex = " + hex);
    }
}
