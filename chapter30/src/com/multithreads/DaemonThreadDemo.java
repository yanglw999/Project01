package com.multithreads;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        UserThread userThread = new UserThread();
        Thread thread = new Thread(userThread, "user thread");
        thread.start();
    }
}
class DaemonThread implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " count: " + i);
        }
    }
}
class UserThread implements Runnable{

    @Override
    public void run() {// set t1 as Daemon thread for User thread
        Thread t1 = new Thread(new DaemonThread(),"Daemon thread");
        t1.setDaemon(true);
        t1.start();

        for(int i = 1; i <= 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "count: " + i);
        }
    }
}
