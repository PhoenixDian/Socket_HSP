package com.phoenixdian.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byName = InetAddress.getByName("--");
        System.out.println(byName);

        InetAddress byName1 = InetAddress.getByName("phoenixdian.com");
        System.out.println(byName1);

        System.out.println(byName1.getHostAddress());

        System.out.println(byName1.getHostName());
    }
}
