import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter two integers: " + "\n");
        int n = input.nextInt();
        int m = input.nextInt();
        int gcd1 = gcd1(n,m);
        System.out.println("the greatest common divisor is: " + gcd1);
        int gcd2 = gcd2(n,m);
        System.out.println("the greatest common divisor is: " + gcd2);

    }
    public static int gcd1(int a, int b){
        int greatest = 1;
        for(int i =1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0){
                greatest = i;
            }
        }
        return greatest;
    }
    public static int gcd2(int a, int b){
        int biggest = 1;  // gcd
        int small = (a < b)? a : b;
        while (small > 0){
            if(a % small == 0 && b % small == 0) {
                biggest = small;
                break;
            }
            small--;
        }
        return biggest;
    }
}
