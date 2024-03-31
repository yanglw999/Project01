import java.util.Scanner;

public class Plindrome {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("enter a number or String: ");
        String str = input.next();
        boolean flag = true;
        for (int i = 0; i <= str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println(str + " is a Plindrome.");
        }else {
            System.out.println(str + " is not Plindrome.");
        }
    }
}
