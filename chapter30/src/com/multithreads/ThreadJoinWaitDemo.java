package com.multithreads;

public class ThreadJoinWaitDemo {
    public static void main(String[] args) {

     PrintMark printMark = new PrintMark('/',100);
        PrintNum print200 = new PrintNum(200);

        Thread threadMark = new Thread(printMark);
        Thread thread200 = new Thread(print200);

       // thread200.start();
        threadMark.start();
    }
}
class PrintMark implements Runnable{
    private int n;
    private char ch;
    public PrintMark(char ch, int n){
        this.ch = ch;
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts");
        PrintChar printC = new PrintChar('C',300);
        Thread threadC = new Thread(printC);
        threadC.start();
        //threadC can only be created in run() of current thread
        // if it wants to cut in the current thread
        try {
            for(int i = 1; i <=500; i++){
                if(i == 101)
                    threadC.join();

                if (i % 30 == 0)
                    System.out.println(ch + " ");
                else
                    System.out.print(ch + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " terminates");
    }
}
