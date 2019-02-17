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
    private long mem_used;

    /**
     * Cpu指标
     */
    // Cpu使用比率
    private long cpu_used_persent;

    /**
     * 磁盘指标
     */
    // 磁盘总量 单位 byte
    private long disk_total;
    // 当前已消耗磁盘 单位 byte
    private long disk_used;

    public void clear() {
        this.mem_total = 0L;
        this.mem_used = 0L;
        this.cpu_used_persent =0L;
        this.disk_total = 0L;
        this.disk_used = 0L;
    }

    public Map<String, Object> generateParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("device", LMCConstants.DEVICE_NAME);
        params.put("mem_total", this.mem_total);
        params.put("mem_used", this.mem_used);
        params.put("cpu_used_persent", this.cpu_used_persent);
        params.put("disk_total", this.disk_total);
        params.put("disk_used", this.disk_used);
        params.put("timestamp", System.currentTimeMillis());
        return params;
    }

    public long getMem_total() {
        return mem_total;
    }

    public void setMem_total(long mem_total) {
        this.mem_total = mem_total;
    }

    public long getMem_used() {
        return mem_used;
    }

    public void setMem_used(long mem_used) {
        this.mem_used = mem_used;
    }

    public long getCpu_used_persent() {
        return cpu_used_persent;
    }

    public void setCpu_used_persent(long cpu_used_persent) {
        this.cpu_used_persent = cpu_used_persent;
    }

    public long getDisk_total() {
        return disk_total;
    }

    public void setDisk_total(long disk_total) {
        this.disk_total = disk_total;
    }

    public long getDisk_used() {
        return disk_used;
    }

    public void setDisk_used(long disk_used) {
        this.disk_used = disk_used;
    }
}
