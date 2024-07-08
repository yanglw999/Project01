package chapter24.com;

public class MyStack<E>{
    public final static int CAPACITY = 16;
    private E [] arr = (E[])new Object[CAPACITY];
    private int size;
    public MyStack(){

    }
    public MyStack(int capacity){
        arr = (E[]) new Object[capacity];
    }
    public void capacityCheck(){
        if(size >= arr.length){
            E [] newArr = (E[]) new Object[arr.length *2 + 1];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr = newArr;
        }
    }
    public void push(E o){
        capacityCheck();
        arr[size ++] = o;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E pop(){
        if (isEmpty()) {
            //throw new EmptyStackException();
            System.out.println(" The stack is empty!");
            return null;
        }
        return arr[--size]; // size = size -1, size changed
    }
    public E peek(){
        return arr[size -1]; // size did not change
    }
    public int getSize(){
        return size;
    }
    public void clear(){
        arr = (E[])new Object[CAPACITY];
        size = 0;
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>(9);
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
        myStack.clear();
        System.out.println("size of myStack: " + myStack.getSize());
        myStack.pop();
    }

}
