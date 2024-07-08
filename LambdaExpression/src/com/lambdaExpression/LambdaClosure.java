package com.lambdaExpression;
@FunctionalInterface
interface Display<T>{
    void show( );
}
public class LambdaClosure {
    public static void main(String[] args) {
        int i = 5;
        Display<Integer> display = () -> System.out.println(i);
        //i++; Error
        // once var has been called by lambda, it becomes final and unchangeable
        display.show();
    }
}
