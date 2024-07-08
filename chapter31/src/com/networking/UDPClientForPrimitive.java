package com.networking;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClientForPrimitive {
    public static void main(String[] args) {
        int n = 2000;
        DatagramSocket socket = null;
        ByteArrayOutputStream byteStream = null;
        DataOutputStream dataStream = null;
        try{
            byteStream = new ByteArrayOutputStream();
            dataStream = new DataOutputStream(byteStream);
            dataStream.writeInt(n);
            byte[] buff = byteStream.toByteArray();
            DatagramPacket packet =
                    new DatagramPacket(buff,buff.length,
                            new InetSocketAddress("10.0.0.132",9000));
            socket = new DatagramSocket(7000);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(byteStream != null){
                try {
                    byteStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(dataStream != null){
                try {
                    dataStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                socket.close();
            }
        }
    }
}
