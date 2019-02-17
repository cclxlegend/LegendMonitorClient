package com.cc.monitor.client.util;

import java.net.InetAddress;

public class IpUtil {

    public static String getHostName(){
        InetAddress inetAddress = null;
        try{
            inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostName();
        }catch(Exception e) {
            e.printStackTrace();
            return "unkownHost";
        }
    }

    public static String getLocalIp(){
        InetAddress inetAddress = null;
        try{
            inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        }catch(Exception e) {
            e.printStackTrace();
            return "unkownHost";
        }
    }

}
