package com.multithreads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class CashAccountDemo {
    // another way to connect class
    public static void main(String[] args) throws InterruptedException {
        CashAccount account = new CashAccount("0001");
        DepositTask depositTask = new DepositTask(account,10);
        WithdrawTask withdrawTask1 = new WithdrawTask(account,5);
        WithdrawTask withdrawTask2 = new WithdrawTask(account,8);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(depositTask);
        executorService.execute(withdrawTask1);
        executorService.execute(withdrawTask2);

        Thread.sleep(2000);
        System.out.println(account.getBalance());
        executorService.shutdown();
    }
}
class DepositTask implements Runnable{
    private CashAccount account;
    private double amount;
//by constructor to introduce the class
    public DepositTask(CashAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (this.account){// way 1: synchronized
            account.deposit(amount);
            System.out.println(Thread.currentThread().getName() + " done deposit . "+
                    "\t\tbalance: " + account.getBalance());
        }
    }
}
class WithdrawTask implements Runnable{
    private CashAccount account;
    private double amount;

    public WithdrawTask(CashAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
       account.withdraw(amount);
    }
}
class CashAccount{
    private double balance;
    private String AccountNum;

    public CashAccount(String accountNum) {
        AccountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double num){
        balance = balance + num;
    }
    //way 2: synchronized
    public synchronized void withdraw(double num)  {
        if(Double.compare(getBalance(), num) > 0){
           double newBalance = balance - num;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
            System.out.println(Thread.currentThread().getName() +
                    " done withdraw. "+ "\t\tbalance: " + getBalance());
        }else {
            System.out.println("balance is not enough to withdraw");
        }
    }
}
