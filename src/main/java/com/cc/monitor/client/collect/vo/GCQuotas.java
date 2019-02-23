package com.cc.monitor.client.collect.vo;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class GCQuotas {


    public static void main(String args[]){
        for (final GarbageCollectorMXBean garbageCollector : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println(garbageCollector.getName());
        }
    }
}
