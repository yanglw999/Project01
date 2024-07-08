package com.networking;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class BasicClientSocket {
    public static void main(String[] args)  {
        Socket socket = null;
       // BufferedWriter out = null;
        PrintWriter out = null;
        BufferedReader input = null;
        BufferedReader in = null;
        try {
            String str = InetAddress.getLocalHost().getHostAddress();
             socket = new Socket(str,8888);// host should be the server IP/hostName
            // since server and client share same machine, using local host address
            input = new BufferedReader(new InputStreamReader(System.in));

            out  = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          while (true){
              out.println(input.readLine());
              out.flush();
              System.out.println("server: " + in.readLine());
           }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                    out.close();
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(input != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
