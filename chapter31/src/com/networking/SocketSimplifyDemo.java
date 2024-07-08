package com.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketSimplifyDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null; // closed in main thread, so stay outside of try{}
        try{// socket will be used in sub-thread, so should not be closed in main thread
            Socket socket = null;
            System.out.println("Local host IP address: " +
                    InetAddress.getLocalHost().getHostAddress());
            System.out.println("please enter : server,<port#> OR <IP>,<port#> without space: ");

            // BufferedReader is also used in sub-thread, so shouldn't be closed in main thread
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             String str = input.readLine();
             String [] arr = str.split(",");

             if(arr[0].equals("server")|| arr[0].equals("Server") ){
                 serverSocket = new ServerSocket(Integer.parseInt(arr[1]));
                 System.out.println("connecting and listening port: " + arr[1]);
                 socket = serverSocket.accept();
             }else {
                 socket = new Socket(arr[0],Integer.parseInt(arr[1]));
                 System.out.println("connected with port " + arr[1]);
             }
        // both sides will start below two sub-threads
             new Thread(new Sender(socket, input)).start();
             new Thread(new Receiver(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Sender implements Runnable{
    private Socket socket;
    BufferedReader input;
    public Sender(Socket socket, BufferedReader input)  {
        this.socket = socket;
        this.input = input;
    }
    @Override
    public void run() {
        messageSender();
    }
    private void messageSender(){
        //Scanner is a substitute of BufferedReader
       // BufferedReader input = null;
        PrintWriter out = null;
        //BufferedWriter out = null;
        try {
           // input = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream());
            while (true) {
                out.println( input.readLine());
                out.flush(); // flush() is required
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(out != null){
                out.close();
            }// thread has finished, so close socket in any one sub-thread
            // and socket only needs to be closed once, since 6 threads share socket
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Receiver implements Runnable{
    private Socket socket;
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        messageReceiver();
    }
    private void messageReceiver() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                System.out.println("reply: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}