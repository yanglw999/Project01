package com.generic;

public class GenericStackArray<E> {
    public static int INITIAL_SIZE = 3; // constant must not be limited with private and must accompany with static
    private int count = 0;
    private E[] list;
  //  E [] list = (E[]) new Object[capacity];
    public GenericStackArray(){
        this(INITIAL_SIZE); //???
    }
    public GenericStackArray(int capacity){
        list = (E[]) new Object[capacity];
    }

    public void push(E element){
        if(count >= list.length){
            E[] newList = (E[]) new Object[2*list.length];
            System.arraycopy(list,0,newList,0,list.length);
            list = newList;
        }else {
            list[count] = element;// or list[count++] = element
            count++;
        }
    }
    /** Return and remove the top element from the stack */
    public E pop(){          // count is changed
        return list[--count];// count = count - 1; return list[count]
    }
    /** Return the top element from the stack */
    public E peek(){
        return list[count -1]; // count is unchanged
    }
    public boolean isEmpty(){
        return count == 0;
    }

    public int getSize(){
        return count;
    }
}
