package com.multithreads;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) throws IOException {
        //interface ExecutorService extends interface Executor
        // class Executors contains static newFixedThreadPool() & static newCachedThreadPool()
        //both static methods return the instance of ExecutorService
        // ExecutorService has more abstract methods including execute()
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new showSign('+', 60));
        executor.execute(new showSign('?',60));
        executor.execute(new showSign('A',60));
        List<Runnable> list =  executor.shutdownNow();
        System.out.println(executor.isShutdown());
        System.out.println("all tasks are terminated? " + executor.isTerminated());
        for(Runnable ele: list){
            System.out.println(ele);
        }
    }
}
class showSign implements Runnable{
    private char ch;
    private int n;
    public showSign(char ch, int n){
        this.ch = ch;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 30 == 0)
                System.out.println(ch + " ");
            else
                System.out.print(ch + " ");
        }
    }
}
