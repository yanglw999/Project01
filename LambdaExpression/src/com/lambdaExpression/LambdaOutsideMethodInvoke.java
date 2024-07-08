package com.lambdaExpression;
class NumMath{
    public static int sum(int a, int b){
        return a + b;
    }
    public void read(){
        System.out.println("welcome to NumMath class");
    }
}
public class LambdaOutsideMethodInvoke {
    public static void main(String[] args) {
        //1. using static method to replace abstract method implementation
        ReturnWithMoreArgs returnWithMoreArgs = NumMath ::sum;
        int value = returnWithMoreArgs.method(5,6);
        System.out.println("sum: " + value);
        //2. using instance method to replace abstract method implementation
        NumMath numMath = new NumMath();
        NoReturnNoArgs noReturnNoArgs = numMath::read;
        noReturnNoArgs.method();
    }
}
