package com.lambdaExpression;
public class LambdaThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " starts: ");
        //1. using lambda to run a thread
        new Thread(() ->{
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }).start();
        //2. using anonymous inner class the run a thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }).start();
        //3. regular way to run a thread
        new Thread(new WriteTask()).start();
        System.out.println(Thread.currentThread().getName() + " ends. ");
    }
}
class WriteTask implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
