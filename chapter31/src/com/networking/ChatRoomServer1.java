package com.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// chat room can not speak on its own, it's just a platform for others talking
public class ChatRoomServer1 {
    public static String buff;
  //  public static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
  //  public static BufferHub<String> bufferHub = new BufferHub<>(1);

    public static void main(String[] args) {
        int port = 8000;
        ServerSocket server = null;
        try{
             server = new ServerSocket(8000);
            System.out.println("chat room server with port: 8000 is opening: ");
            while (true){
                Socket socket = server.accept();
                System.out.println("[" + socket.getInetAddress() + "] is joining! ");
                new ChatReceiver1(socket).start();
                new ChatSender1(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class ChatSender1 extends Thread{
    Socket socket;

    public ChatSender1(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        sendMessage();
    }
    private void sendMessage(){
        PrintWriter out = null;
        try{
            out = new PrintWriter(socket.getOutputStream());
            while (true){
                synchronized ("sign"){
                    // let the threads waited since no info in buffer
                    "sign".wait();
                    // after adding info into buffer, notifyAll() wakes all waiting threads
                    out.println(ChatRoomServer1.buff);
                    out.flush();
                }

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
        }
    }
}
class ChatReceiver1 extends Thread{
    Socket socket;

    public ChatReceiver1(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        receiveMessage1();
    }
    private void receiveMessage1(){
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String string = "[" + socket.getInetAddress() + "]: " + in.readLine();
                synchronized ("sign"){
                    ChatRoomServer1.buff = string;
                    // notify all waited objects that info in the buff
                    "sign".notifyAll();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class BufferHub<E>{
    private LinkedList<E> buff;
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    public BufferHub(int capacity){
        buff = new LinkedList<>();
        this.capacity = capacity;
    }
    public void write(E e){
        lock.lock();
        try{
            while (buff.size() == capacity){
                notFull.await();
            }
            buff.add(e); // buff has at least one element now
            notEmpty.signalAll(); // so signal all listeners
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public E read(){
        lock.lock();
        E value = null;
        try{
            while (buff.isEmpty()){
                notEmpty.await();
            }
             value = buff.removeFirst();// buff has at least one element removed
            notFull.signalAll();// so signal all listeners
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            return value;
        }
    }
}