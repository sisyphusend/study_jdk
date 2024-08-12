package com.breakingbad.address;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testAddress {
    @Test
    public void test01() throws UnknownHostException {
        // 获取本机ip
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);
        String hostName = localHost.getHostName();
        System.out.println(hostName);
        for (byte addr: localHost.getAddress()) {
            System.out.println(addr);
        }

    }
}
