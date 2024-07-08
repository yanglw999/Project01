public class GCD {
    public static void main(String[] args) {
        System.out.println("the greatest common divisor is: "+ Gcd(8,48,16,72,12));
    }
    public static int Gcd(int ... numbers){
        int min = numbers[0];
        int gcd = -1;
        for(int i = 0; i < numbers.length; i++){
            if(min > numbers[i]){
                min = numbers[i];
            }
        }
        for(int j = min; j > 0; j--){
            boolean isGcd = true;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % j != 0){
                    isGcd = false;
                    break;
                }
            }

            if(isGcd){
                gcd = j;
                break;
            }
        }
        return gcd;
    }
}
