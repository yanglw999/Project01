package com.multithreads;

import java.io.IOException;

public class StopThread implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts: ");
        try {
            int n = 1;
            while (flag){
                System.out.print( n++ + " " );
                System.out.print(Thread.currentThread().getName() + " id:");
                System.out.println(Thread.currentThread().getId());
                // current thread sleeps 1 second
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " terminates.");
    }
    public void stop(){
        flag = false;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("main thread starts:");
        StopThread stopThread = new StopThread();
        // stopThread is not a thread until started by start()
        Thread thread = new Thread(stopThread);
        thread.start();

        System.in.read();// delay main thread to terminate
        stopThread.stop();
        //stopThread = null; // this does not work
        System.out.println("main thread terminates.");
    }
}
