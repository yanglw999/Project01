package com.multithreads;

public class ClassThreadDemo {
    public static void main(String[] args) {
        System.out.println("main thread begins: ");
        PrintSign printSign = new PrintSign('+',100);
        PrintInt printInt = new PrintInt(100);
        printSign.start();
        printInt.start();
        System.out.println("main thread ends.");
        // main thread has terminated but child threads keep running
    }
}
// method 2: extends Thread class and override run(),
// since Thread implements Runnable interface
// PrintSign inherits all methods from Thread including the run() implemented by Thread
class PrintSign extends Thread {
    // PrintSign is a thread, since extends Thread class
    private char ch;
    private int times;

    public PrintSign(char ch, int n) {
        // getName() is a instance method of Thread
        System.out.println(this.getName() + " id: " + this.getId());
        this.ch = ch;
        this.times = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= times; i++) {
            if (i % 30 == 0)
                System.out.println(ch + " ");
            else
                System.out.print(ch + " ");
        }
    }
}
class PrintInt extends Thread{
    private int n;
    public PrintInt(int n){
        System.out.println(this.getName() + " id: " + this.getId());
        this.n = n;
    }
    @Override
    public void run() {
        for(int i = 1; i <= n; i++){
            if(i % 30 ==0)
                System.out.println(i + " ");
            else
                System.out.print(i + " ");
        }
    }
}
