public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("display the first 100 prime numbers: ");

        int num = 2;
        int n = 1;
        while(n <= 100){
            boolean isPrimeNumber = true;
            for(int i = 2; i < num; i++ ){
                if(num % i == 0){
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber){
                if(n % 10 != 0){
                    System.out.printf("%-5d", num);
                }else{
                    System.out.printf("%-5d\n", num);
                }
                n++;
            }
            num++;
        }

    }
}
