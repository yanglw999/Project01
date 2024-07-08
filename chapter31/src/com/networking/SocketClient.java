package com.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        // host should be the server IP/hostName
        // since server and client share same machine, using local host address
        String str = InetAddress.getLocalHost().getHostAddress();
        // socket should not be closed.
            Socket socket = new Socket(str, 8888);
            ExecutorService service = Executors.newCachedThreadPool();
            service.execute(new SendClient(socket));
            service.execute(new ReceiveClient(socket));
            service.shutdown();
    }
}
class SendClient implements Runnable{
    private Socket socket;

    public SendClient(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        clientMessageSender();
        }
      private void  clientMessageSender(){
          BufferedReader input = null;
          // Scanner is also a substitute of BufferedReader
          PrintWriter out = null;
          //BufferedWriter does not work
          try {
              input = new BufferedReader(new InputStreamReader(System.in));
              out = new PrintWriter(socket.getOutputStream());
              while (true) {
                  out.println(input.readLine());
                  out.flush();
              }
          }catch (IOException e) {
              e.printStackTrace();
          }finally {
              if(input != null){
                  try {
                      input.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
              if (out != null){
                  out.close();
              }// this one is not necessary
             /* if(socket != null) {
                  try {
                      socket.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }*/
          }
        }
    }
class ReceiveClient implements Runnable{
    Socket socket;

    public ReceiveClient(Socket socket) {
       this.socket = socket;
    }

    @Override
    public void run(){
       clientMessageReceiver();
    }
    private void clientMessageReceiver(){
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