package com.multithreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithoutSync {
    // the reason to make Account static is that static AddPennyTask needs to invoke Account
    private  static Account account= new Account();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for(int i = 1; i <= 100; i++){
            executor.execute(new AddPennyTask());
        }
        executor.shutdown();
    }
 // the reason to make inner class AddPennyTask static is that the static main() needs to invoke it
     static class AddPennyTask implements Runnable{

        @Override
        public void run() {
            account.deposit(1);
            System.out.println(Thread.currentThread().getName() + " balance: " + account.getBalance());
        }
    }
}
class Account{
    Lock lock = new ReentrantLock();
    private int balance;
    public int getBalance(){
        return balance;
    }
    public void deposit(int amount)  {
        lock.lock();
        try {
        int newBalance = balance + amount;
        // This delay is deliberately added to magnify the data-corruption problem
        // and make it easy to see
            Thread.sleep(5);
            balance = newBalance;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}