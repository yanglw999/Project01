package com.multithreads;
import java.io.IOException;

public class PriorityDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        Thread thread1 = new Thread(tp1,"thread 1");
        Thread thread2 = new Thread(tp2,"thread 2");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        System.out.println("thread1 priority: " + thread1.getPriority());
        // main thread sleeps 1 second
        Thread.sleep(1000);
        //System.in.read();     OR
        tp1.stop();
        tp2.stop();
        System.out.println("main thread ends");
    }
}
class ThreadPriority implements Runnable{
    private long n;
    boolean flag = true;
    public ThreadPriority(){}

    @Override
    public void run() {
        while (this.flag){
            ++n;
            Thread.currentThread().getName();// this statement is required.
            // otherwise, stop() does not work
        }
        System.out.println(Thread.currentThread().getName() + " runs: " + n + " times");

    }
    public void stop(){
        this.flag = false;
    }
}