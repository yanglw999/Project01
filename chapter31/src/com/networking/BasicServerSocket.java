package com.networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServerSocket {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        // BufferedWriter can not send message to client, so replaced with PrinterWriter
       // BufferedWriter out = null;
        PrintWriter out = null;
        ServerSocket server = null;
        BufferedReader input = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("server starts monitoring port:");
            socket = server.accept(); //accept() returns a instance of Socket

            input = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            while (true){
                System.out.println("client: " + in.readLine());
                out.println(input.readLine());
                out.flush(); //PrintWriter needs flush
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
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                    out.close();
                }
            }
            if(server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
