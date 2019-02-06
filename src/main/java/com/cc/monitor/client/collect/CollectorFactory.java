package com.cc.monitor.client.collect;


import com.cc.monitor.client.collect.sys.impl.LinuxCollector;
import com.cc.monitor.client.collect.sys.impl.MacCollector;
import com.cc.monitor.client.collect.sys.impl.WinCollector;
import com.cc.monitor.client.schedule.TaskList;

import java.util.HashMap;
import java.util.Map;

public class CollectorFactory {

    private static Map<String, ICollector> cache = new HashMap<>();

    private CollectorFactory() {

    }

    public static ICollector getSingeltonCollector(String key) {
        if (key == null || key.isEmpty()) {
            return null;
        }
        ICollector collector = cache.get(key);
        if (collector == null) {
            if(!TaskList.getSingletonTaskList().contains(key)){
                return null;
            }
            if("sys-mac".equals(key)){
                collector = new MacCollector();
            }else if("sys-windows".equals(key)){
                collector = new WinCollector();
            }else if("sys-linux".equals(key)){
                collector = new LinuxCollector();
            }
        }
        return collector;
    }

    public static ICollector newCollector(String key) {
        return null;
    }
}
