package com.lambdaExpression;
@FunctionalInterface
interface NoReturnNoArgs{
    void method();
}
@FunctionalInterface
interface NoReturnWithMoreArgs{
    void method(int a, int b);
}
@FunctionalInterface
interface ReturnWithMoreArgs{
    int method(int a, int b);
}
public class LambdaTest {
    public static void main(String[] args) {
        // implement abstract void method()
        // empty () can not be left out
        NoReturnNoArgs noReturnNoArgs = () ->{
            System.out.println(" the method has no value Return No Args");
        };
        noReturnNoArgs.method();
        // implement abstract void method(int a, int b)
        // {} is omitted, since only on statement in method body
        NoReturnWithMoreArgs noReturnWithMoreArgs = (int a, int b) ->
            System.out.println("sum = " + (a + b) );

        noReturnWithMoreArgs.method(3,4);
        // implement abstract int method(int a, int b)
        // args types are omitted,
        // if method body only has one statement, {} & return can be omitted
        ReturnWithMoreArgs returnWithMoreArgs = (a, b) -> {
            return a * b;
        };

        int value = returnWithMoreArgs.method(3,4);
        System.out.println("product = " + value);
    }
}
