package com.example;

public class StackOfIntegers {
    private int[]elements = new int[10];// default
    private int size;
    public StackOfIntegers(int capacity){
        elements = new int[capacity];
    }
    public StackOfIntegers(){
        this(16);
    }

    /**Push a new integer to the top of the stack */
    public void push(int value){ // System.arraycopy()
        if(size >= elements.length){
            int[]temp = new int[elements.length + 1];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements = temp;
        }
        elements[size++] = value; // elements[size] = value; size++;
    }
    /** Return the top element from the stack one by one */
    public int pop(){   // remove != delete
        return elements[--size];//  size = size-1; elements[size];
    }
    /** return top element from the stack*/
    public int peek(){
        return elements[size - 1];
    }
    public boolean empty(){
        return (size == 0) ? true : false;
    }
    public int getSize(){
        return size;
    }
}
