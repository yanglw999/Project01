public class PrimeNumberMethod {
    public static void main(String[] args) {
        System.out.println("print first m prime numbers: ");
        primeNum(100);

    }
    public static void primeNum(int m){
    int num = 2;
    int n = 1;
        while(n <= m) {
            boolean isPrimeNumber = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                if (n % 10 != 0) {
                    System.out.printf("%-5d", num);
                } else {
                    System.out.printf("%-5d\n", num);
                }
                n++;
            }
            num++;
        }
    }
}
