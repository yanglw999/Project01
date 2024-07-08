package com.networking;

import java.net.InetSocketAddress;

public class InetSocketAddressTest {
    public static void main(String[] args) {
        //InetSocketAddress is similar to InetAddress but specify a port
        InetSocketAddress inetSocketAddress =
                new InetSocketAddress("www.google.com", 80);
        System.out.println(inetSocketAddress.getAddress().getHostName());
        System.out.println(inetSocketAddress.getAddress().getHostAddress());
    }
}
