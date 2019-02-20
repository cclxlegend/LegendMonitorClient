package com.cc.monitor.client.collect.sys;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.vo.SysQuotas;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Map;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Component;


import static com.cc.monitor.client.constants.LMCConstants.SYS_JOB_INTERVAL;

@Component("sysCollector")
public class SysCollector implements ICollector {

    private OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    protected SysQuotas quotas = SysQuotas.getInstance();

    public SysCollector(){

    }

    private void collectMemory(){
        // 内存信息
        quotas.setMem_total(operatingSystemMXBean.getTotalPhysicalMemorySize());
        quotas.setMem_free(operatingSystemMXBean.getFreePhysicalMemorySize());
        quotas.setMem_commited_vitual(operatingSystemMXBean.getCommittedVirtualMemorySize());
    }

    private void collectCpu(){
        quotas.setCpu_load(operatingSystemMXBean.getSystemCpuLoad());
        quotas.setProcess_cpu_load(operatingSystemMXBean.getProcessCpuLoad());
    }

    private void collectDisk(){
        File[] dics = File.listRoots();
        long diskTotal = 0L;
        long diskFree = 0L;
        for(File file:dics){
            diskTotal += file.getTotalSpace();
            diskFree += file.getFreeSpace();
        }
        quotas.setDisk_total(diskTotal);
        quotas.setDisk_free(diskFree);
    }

    @Override
    public Map<String,Object> collect() throws Exception {
        quotas.clear();
        collectMemory();
        collectCpu();
        collectDisk();
        return quotas.generateParams();
    }

    public String key() {
        return "sys";
    }
}
