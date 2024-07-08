package com.multithreads;

public class TaskThreadDemo {
    public static void main(String[] args) {
        PrintChar printA = new PrintChar('A',100);
        PrintChar printB = new PrintChar('B', 100);
        PrintNum print100 = new PrintNum(100);

        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);
        Thread thread100 = new Thread(print100);
        threadA.start();
        thread100.start();
        threadB.start();
    }
}
// method 1: implements Runnable interface and implements run()
class PrintChar implements Runnable {
    //PrintChar is not thread, it's just a class implementing Runnable interface
    private char ch;
    private int times;

    public PrintChar(char ch, int n) {
        // static Thread currentThread(){} // return an object of Thread,
        // so can invoke all methods and properties of Thread
        System.out.println(Thread.currentThread().getName()); // return main thread name
        // when invoke PrintChar constructor, it is not thread yet, until its run() starts
        // it's just a class implementing Runnable interface
        this.ch = ch;
        this.times = n;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " id: " + Thread.currentThread().getId());
        for (int i = 1; i <= times; i++) {
            if (i % 30 == 0)
                System.out.println(ch + " ");
            else
                System.out.print(ch + " ");
        }
    }
}
class PrintNum implements Runnable{
    private int n;
    public PrintNum(int n){
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " id: " + Thread.currentThread().getId());
        for(int i = 1; i <= n; i++){
            if(i % 30 ==0)
                System.out.println(i + " ");
            else
                System.out.print(i + " ");
        }
    }
}
