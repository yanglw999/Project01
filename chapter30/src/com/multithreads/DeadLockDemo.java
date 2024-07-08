package com.multithreads;

public class DeadLockDemo {
    public static void main(String[] args) {
        new MakeupTask("Penny", new Lipstick(), new Mirror(),0).start();
        new MakeupTask("Mary", new Lipstick(), new Mirror(),1).start();
    }
}
class MakeupTask extends Thread{
    private static Lipstick lipstick;
    private static Mirror mirror;
    private String girlName;
    private int flag;
    public MakeupTask(String girlName, Lipstick lipstick, Mirror mirror, int flag){
        this.lipstick = lipstick;
        this.mirror = mirror;
        this.girlName = girlName;
        this.flag = flag;
    }
    @Override
    public void run() {
        this.doMakeup();
    }
    public void doMakeup(){
        if(flag == 0){
            synchronized (lipstick){
                System.out.println(girlName + " holds lipstick.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }// just move the inserted synchronized block out, deadlock is resolved
            synchronized (mirror){
                System.out.println(girlName + " holds mirror.");
            }
        }else{
            synchronized (mirror){
                System.out.println(girlName + " holds mirror.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick){
                System.out.println(girlName + " holds lipstick.");
            }
        }
    }
}
class Lipstick {
}
class Mirror{
}