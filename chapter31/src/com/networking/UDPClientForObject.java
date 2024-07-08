package com.networking;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClientForObject {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        ObjectOutputStream object = null;
        ByteArrayOutputStream byteStream = null;
        try{
            Car car = new Car("Tesla", 60000);
            byteStream = new ByteArrayOutputStream();
            byte [] buff = byteStream.toByteArray();

            object = new ObjectOutputStream(byteStream);
            object.writeObject(car);
            DatagramPacket packet =
                    new DatagramPacket(buff,buff.length,
                            new InetSocketAddress("10.0.0.132",9000));
            socket = new DatagramSocket(6000);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(byteStream != null){
                try {
                    byteStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(object != null){
                try {
                    object.close();
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
