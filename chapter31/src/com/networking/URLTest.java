package com.networking;
import java.net.MalformedURLException;
import java.net.URL;
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.rolex.com/watches/sky-dweller/m336934-0002");
        System.out.println(url.getDefaultPort()); // https port: 443
        System.out.println("resource: " + url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getProtocol());
        System.out.println("parameters: " + url.getQuery());
    }
}
