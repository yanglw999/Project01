import java.util.Random;
import java.util.Scanner;

class Lottery649 {
    public static void main(String[] args) {
        System.out.println("how many set of numbers?");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Random random = new Random();
        System.out.println("the numbers you need are as below: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 7; j++){
                // int _649 = (int) (Math.random() * 49 + 1);
                int _649 = random.nextInt(49);
                System.out.print(_649 + " ");
            }
            System.out.println();
        }
    }
}
