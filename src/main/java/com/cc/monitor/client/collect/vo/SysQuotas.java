package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.annotation.QuotaParameter;
import com.cc.monitor.client.collect.AbstractQuotas;

public class SysQuotas extends AbstractQuotas {

    /**
     * 内存指标
     */

    // 总内存 单位byte
    @QuotaParameter
    private long mem_total;
    // 已消耗的内存
    @QuotaParameter
    private long mem_free;
    // 已交换的虚拟内存
    @QuotaParameter
    private long mem_commited_vitual;

    /**
     * Cpu指标
     */
    // Cpu使用比率
    @QuotaParameter
    private double cpu_load;
    // 当前进程占用CPU比率
    @QuotaParameter
    private double process_cpu_load;

    /**
     * 磁盘指标
     */
    // 磁盘总量 单位 byte
    @QuotaParameter
    private long disk_total;
    // 当前已消耗磁盘 单位 byte
    @QuotaParameter
    private long disk_free;

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
