package com.cc.monitor.client.collect.vo;

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
    private long mem_total_size;
    // 已消耗的内存
    private long mem_used;

    /**
     * Cpu指标
     */
    // Cpu使用比率
    private long cpu_used;

    /**
     * 磁盘指标
     */
    // 磁盘总量 单位 byte
    private long disk_total_size;
    // 当前已消耗磁盘
    private long disk_used;

    /**
     * 网络流量指标
     */

    // 网络最大支持流量 单位 byte
    private long netflow_total_size;
    // 当前流入总packet数量
    private long netflow_packet_in;
    // 当前流入总流量
    private long netflow_byte_in;
    // 当前流出总packet数量
    private long netflow_packet_out;
    // 当前流出总流量
    private long netflow_byte_out;


    public void clear() {
        this.mem_total_size = 0L;
        this.mem_used = 0L;
        this.cpu_used = 0L;
        this.disk_total_size = 0L;
        this.disk_used = 0L;
        this.netflow_total_size = 0L;
        this.netflow_packet_in = 0L;
        this.netflow_byte_in = 0L;
        this.netflow_packet_out = 0L;
        this.netflow_byte_out = 0L;

    }

    public Map<String, Object> generateParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("mem_total_size", this.mem_total_size);
        params.put("mem_used", this.mem_used);
        params.put("cpu_used", this.cpu_used);
        params.put("disk_total_size", this.disk_total_size);
        params.put("disk_used", this.disk_used);
        params.put("netflow_total_size", this.netflow_total_size);
        params.put("netflow_packet_in", this.netflow_packet_in);
        params.put("netflow_byte_in", this.netflow_byte_in);
        params.put("netflow_packet_out", this.netflow_packet_out);
        params.put("netflow_byte_out", this.netflow_byte_out);
        params.put("timestamp", System.currentTimeMillis());

        return params;
    }


}
