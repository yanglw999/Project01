package com.example;

public class StackOfIntegerTest {
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers(8);
        for(int i = 0; i < 10; i++){
            stack.push(i); // StackOfInteger.pop() is wrong
        }
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}
