public class QuotientWithException {
    public static void main(String[] args) {
        double a = 5;
        double b = 1;
       try{
           double answer = quotient(a, b);
           System.out.println(a + " / " + b + " = " + a / b);
       }
       catch (ArithmeticException ex){
           System.out.println("Exception: 1 is excluded as divisor.");
       }
        System.out.println("proceeding continues ......");
       }
    public static  double quotient(double a , double b){
        if(b == 1)
            throw new ArithmeticException("divisor cannot be 1.");
        return  a / b;
    }
}
