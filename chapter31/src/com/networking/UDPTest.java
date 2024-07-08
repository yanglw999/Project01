package com.networking;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPTest {
    public static void main(String[] args)  {
        // create a server by UDP
        DatagramSocket datagramSocket = null;
        DataInputStream stream = null; // for primitive type data
        ObjectInputStream objectStream = null;// for object data
        try{
             datagramSocket = new DatagramSocket(9000);
             byte[] buff = new byte[1024];
            DatagramPacket  packet = new DatagramPacket(buff,buff.length);

                // receive the info from client end
                // and wrap the info into packet
                datagramSocket.receive(packet);
                System.out.println("pointer");

                 // OR  // receive primitive-type data
                //    stream = new DataInputStream(new ByteArrayInputStream(packet.getData()));
                 //   System.out.println(stream.readInt());

                 // OR   // convert the byte info in packet into string
                    String str = new String(packet.getData(),0,packet.getLength());
                    System.out.println(str);

                  // OR  // receive a object
                objectStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
                System.out.println(objectStream.readObject().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectStream != null){
                try {
                    objectStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(datagramSocket != null){
                datagramSocket.close();
            }
        }
    }
}
