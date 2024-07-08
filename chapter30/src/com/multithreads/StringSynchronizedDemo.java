package com.multithreads;
public class StringSynchronizedDemo {
    public static void main(String[] args) {
        System.out.println("After add synchronized(\"str\"){}");
        new ProgrammerTask(new Programmer("A")).start();
        new ProgrammerTask(new Programmer("B")).start();
    }
}
class ProgrammerTask extends Thread{
    private Programmer programmer;
    public ProgrammerTask( Programmer programmer){
        this.programmer = programmer;
    }
    @Override
    public void run() {
       programmer.usingPrinter();
    }
}
class Programmer{
    private String name;
    public Programmer(String name) {
        this.name = name;
    }
    public void usingPrinter() {
        synchronized ("and string works") {
            try {// suppose at any moment the printer is only using by one person
                System.out.println(name + " connecting to printer:");
                Thread.sleep(500);
                System.out.println(name + " uploading file");
                Thread.sleep(500);
                System.out.println(name + " printing files");
                Thread.sleep(500);
                System.out.println(name + " clearing files");
                Thread.sleep(500);
                System.out.println(name + " quitting printer.");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
