package com.multithreads;

public class CaseJoinDemo {
    public static void main(String[] args) {
        Thread father = new Thread(new FatherThread());
        father.start();
    }
}
class FatherThread implements Runnable{
    public FatherThread(){

    }

    @Override
    public void run() {
        System.out.println("Dad wanted to drink coffee, but coffee was out.");
        System.out.println("Dad sent son to buy coffee.......");
            Thread sonThread = new Thread(new SonThread());
            sonThread.start();
            try {
                sonThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Dad drank the coffee and hugged the son..");
    }
}
class SonThread implements Runnable{
    public SonThread(){}

    @Override
    public void run() {
        try {
            System.out.println("son went to buy coffee.");
            for(int i = 1; i <= 10; i++){
                Thread.sleep(1000);
                System.out.println(i + " min");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("son brought coffee back home. ");
    }
}
