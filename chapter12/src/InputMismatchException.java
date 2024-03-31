import java.util.Scanner;

public class InputMismatchException {
    public static void main(String[] args) {
        boolean inputContinue = true;
        do {
            try {
                System.out.print("please enter a integer: ");
                Scanner input = new Scanner(System.in);
                //unchecked exception
                int num = input.nextInt(); // the number type does not match the required dataType, exception happens
                // once exception happens, the rest code in try block will not be executed
                System.out.println("the number entered is: " + num);
                inputContinue = false;
            } catch (java.util.InputMismatchException ex) {
                System.out.println("try again, an integer is required.");
            }
        } while (inputContinue);
    }
}
