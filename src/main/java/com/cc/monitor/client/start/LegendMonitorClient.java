package com.cc.monitor.client.start;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class LegendMonitorClient {

    public static void start(){

    }

    public static void main(String args[]){

        final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        System.out.println(runtimeMXBean.getVmName());
        System.out.println(runtimeMXBean.getVmVendor());
        System.out.println(runtimeMXBean.getVmVersion());
    }
}
