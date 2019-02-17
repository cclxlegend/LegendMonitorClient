package com.cc.monitor.client.collect.sys;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.vo.SysQuotas;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


import static com.cc.monitor.client.constants.LMCConstants.SYS_JOB_INTERVAL;

public class SysCollector implements ICollector {

    private OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    protected SysQuotas quotas = SysQuotas.getInstance();

    public SysCollector(){

    }

    public void collectMemory(){
         operatingSystemMXBean.getTotalPhysicalMemorySize();
    }

    @Override
    public void collect() throws Exception {

    }

    public int interval() {
        return SYS_JOB_INTERVAL;
    }

    public String key() {
        return "sys";
    }
}
