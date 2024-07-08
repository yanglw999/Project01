package com.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
    public static void main(String[] args) throws UnknownHostException {
        // InetAddress.getLocalHost()
        InetAddress inetAddress1 = InetAddress.getLocalHost();
        System.out.println(inetAddress1.getHostName());
        System.out.println(inetAddress1.getHostAddress());
        //InetAddress.getByName("www.google.com")
        InetAddress inetAddress2 = InetAddress.getByName("www.google.com");
        System.out.println(inetAddress2.getHostName());
        System.out.println(inetAddress2.getHostAddress());
        //InetAddress.getByName("172.217.165.4")
        // will not get back with a string name like www.google.com
    }
}
