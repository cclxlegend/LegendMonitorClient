package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.constants.LMCConstants;

import java.util.HashMap;
import java.util.Map;

public class SysQuotas {

    private static SysQuotas quotas;

    private SysQuotas() {

    }

    public static SysQuotas getInstance() {
        if (quotas == null) {
            synchronized (SysQuotas.class) {
                if (quotas == null) {
                    quotas = new SysQuotas();
                }
            }
        }
        return quotas;
    }

    /**
     * 内存指标
     */

    // 总内存 单位byte
    private long mem_total;
    // 已消耗的内存
    private long mem_free;
    // 已交换的虚拟内存
    private long mem_commited_vitual;

    /**
     * Cpu指标
     */
    // Cpu使用比率
    private double cpu_load;
    // 当前进程占用CPU比率
    private double process_cpu_load;

    /**
     * 磁盘指标
     */
    // 磁盘总量 单位 byte
    private long disk_total;
    // 当前已消耗磁盘 单位 byte
    private long disk_free;

    public void clear() {
        this.mem_total = 0L;
        this.mem_free = 0L;
        this.mem_commited_vitual =0L;
        this.cpu_load = 0L;
        this.process_cpu_load = 0;
        this.disk_total = 0L;
        this.disk_free = 0L;
    }

    public Map<String, Object> generateParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("device", LMCConstants.DEVICE_NAME);
        params.put("mem_total", this.mem_total);
        params.put("mem_free", this.mem_free);
        params.put("mem_commited_vitual", this.mem_commited_vitual);
        params.put("cpu_load", this.cpu_load);
        params.put("process_cpu_load", this.process_cpu_load);
        params.put("disk_total", this.disk_total);
        params.put("disk_free", this.disk_free);
        params.put("timestamp", System.currentTimeMillis());
        return params;
    }

    public long getMem_total() {
        return mem_total;
    }

    public void setMem_total(long mem_total) {
        this.mem_total = mem_total;
    }

    public long getMem_free() {
        return mem_free;
    }

    public void setMem_free(long mem_free) {
        this.mem_free = mem_free;
    }

    public long getMem_commited_vitual() {
        return mem_commited_vitual;
    }

    public void setMem_commited_vitual(long mem_commited_vitual) {
        this.mem_commited_vitual = mem_commited_vitual;
    }

    public double getCpu_load() {
        return cpu_load;
    }

    public void setCpu_load(double cpu_load) {
        this.cpu_load = cpu_load;
    }

    public double getProcess_cpu_load() {
        return process_cpu_load;
    }

    public void setProcess_cpu_load(double process_cpu_load) {
        this.process_cpu_load = process_cpu_load;
    }

    public long getDisk_total() {
        return disk_total;
    }

    public void setDisk_total(long disk_total) {
        this.disk_total = disk_total;
    }

    public long getDisk_free() {
        return disk_free;
    }

    public void setDisk_free(long disk_used) {
        this.disk_free = disk_used;
    }
}
