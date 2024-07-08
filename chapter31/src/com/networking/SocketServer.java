package com.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        // must be outside of try{}, since need to close in finally{}
        try {
           server = new ServerSocket(8888);
            Socket socket = server.accept();// socket should not be closed.

           new Thread(new Receive(socket)).start();
           new Thread(new Send(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Send implements Runnable{
    private Socket socket;
    public Send(Socket socket)  {
        this.socket = socket;
    }
    @Override
    public void run() {
        messageSender();
    }
    private void messageSender(){
        //Scanner is a substitute of BufferedReader
        BufferedReader input = null;
        PrintWriter out = null;
        //BufferedWriter out = null;
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream());
            while (true) {
                out.println(input.readLine());
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
            }
            if(out != null){
                out.close();
            }// thread has finished, so close socket
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
class Receive implements Runnable{
    private Socket socket;
    public Receive(Socket socket) {
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
                System.out.println(in.readLine());
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
        }
    }
}