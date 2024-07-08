package com.multithreads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
    static ChequeAccount chequeAccount = new ChequeAccount();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        DepositTask depositTask = new DepositTask();
        withdrawTask withdrawTask = new withdrawTask();
        executor.execute(depositTask);
        executor.execute(withdrawTask);
        Thread.sleep(1000);

        depositTask.stop();
        withdrawTask.stop();
        executor.shutdown();
    }
    public static class DepositTask implements Runnable{
        private boolean flag = true;

        @Override
        public void run() {
            try{
                while (flag) {
                    chequeAccount.deposit(new Random(System.currentTimeMillis()).nextInt(10) + 1);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void stop(){
            flag = false;
        }
    }
    public static class withdrawTask implements Runnable{
        private boolean flag = true;
        @Override
        public void run() {
            try{
                while (flag) {// one thread runs many times
                    chequeAccount.withdraw((int)(Math.random() * 10) + 1);
                   Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void stop(){
            flag = false;
        }
    }
}
class ChequeAccount {
    private Lock lock = new ReentrantLock();
    private Condition newDeposit = lock.newCondition();
    private int balance;

    public void withdraw(int amount){
        lock.lock();
        try{
            while (amount > balance){
                System.out.println("\t\tWait for a deposit");
                newDeposit.await();// wait for newDeposit condition, also put current thread on hold
            }// different from .wait(), -> put current thread on hold
            balance -= amount;
            System.out.println("- " + amount +"\t\t\tcurrent balance: " + getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void deposit(int amount){
        lock.lock();
        try{
            int newBalance = balance + amount;
            Thread.sleep(3); // do not need to sleep to observe, since it has lock
            balance = newBalance;
            System.out.println("+ " + amount + "\t\t\tcurrent balance: " + getBalance());
            newDeposit.signalAll(); //signal the thread waiting for deposit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public int getBalance(){
        return this.balance;
    }
}
