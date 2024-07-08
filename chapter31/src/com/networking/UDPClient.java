package com.networking;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try{
            String str = "hello 2024";
            byte[] bytes = str.getBytes();
            // each packet is attached with address of destination
            DatagramPacket packet =
                    new DatagramPacket(bytes,bytes.length,
                            new InetSocketAddress("10.0.0.132",9000));
            // client also has its own port to identify the info sent source
            socket = new DatagramSocket(8000);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket != null){
                socket.close();
            }
        }
    }
}
