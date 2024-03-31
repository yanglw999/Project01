package com.example;

public class Queue {
    private int CAPACITY = 1;
    private int [] nums = new int[CAPACITY];
    private int size;
    private  int index;

    public Queue(){
    }
    public void lineUp(int number){
        if(size >= nums.length) {
            int[] temp = new int[nums.length + 1];
            System.arraycopy(nums,0,temp,0,nums.length);
            nums = temp;
        }
        nums[size] = number;
        size++;

    }
    public int fifo(){ // first in first out

        return  nums[index++] ;// num[index]; index++
    }
    public int lifo(){ // last in first out
        return nums[--size];
    }
    public void firstGone(){
        index++;
    }

    public void restLine(){
        if(size > 0) {
            int[] temp = new int[nums.length - 1];
            System.arraycopy(nums,index,temp,0,nums.length - 1  );
            nums = temp;
        }
        size--;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
        return size;
    }
    public int[] getNums(){
        return nums;
    }
}
