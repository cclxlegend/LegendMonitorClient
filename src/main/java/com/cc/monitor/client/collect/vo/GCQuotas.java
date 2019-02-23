package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.annotation.QuotaParameter;
import com.cc.monitor.client.collect.AbstractQuotas;

/**
 * GC指标、统计JVM运行以来的GC总次数和时间
 */
public class GCQuotas extends AbstractQuotas {

    @QuotaParameter
    private long gcCount;

    @QuotaParameter
    private long gcTime;

    @QuotaParameter
    private long youngGcCount;

    @QuotaParameter
    private long youngGcTime;

    @QuotaParameter
    private long fullGcCount;

    @QuotaParameter
    private long fullGcTime;

    public long getGcCount() {
        return gcCount;
    }

    public void setGcCount(long gcCount) {
        this.gcCount = gcCount;
    }

    public long getGcTime() {
        return gcTime;
    }

    public void setGcTime(long gcTime) {
        this.gcTime = gcTime;
    }

    public long getYoungGcCount() {
        return youngGcCount;
    }

    public void setYoungGcCount(long youngGcCount) {
        this.youngGcCount = youngGcCount;
    }

    public long getYoungGcTime() {
        return youngGcTime;
    }

    public void setYoungGcTime(long youngGcTime) {
        this.youngGcTime = youngGcTime;
    }

    public long getFullGcCount() {
        return fullGcCount;
    }

    public void setFullGcCount(long fullGcCount) {
        this.fullGcCount = fullGcCount;
    }

    public long getFullGcTime() {
        return fullGcTime;
    }

    public void setFullGcTime(long fullGcTime) {
        this.fullGcTime = fullGcTime;
    }
}
