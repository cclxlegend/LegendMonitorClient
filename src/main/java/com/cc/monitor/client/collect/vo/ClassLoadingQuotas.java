package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.annotation.QuotaParameter;
import com.cc.monitor.client.collect.AbstractQuotas;

public class ClassLoadingQuotas extends AbstractQuotas {

    /**
     * 当前已加载的类的数量
     */
    @QuotaParameter
    private long loadedClassCount;

    /**
     * JVM运行以来加载的类的总数量
     */
    @QuotaParameter
    private long totalloadedClassCount;

    /**
     * 当前未被加载(或已被卸载)的类的数量
     */
    @QuotaParameter
    private long unloadedCount;

    public long getLoadedClassCount() {
        return loadedClassCount;
    }

    public void setLoadedClassCount(long loadedClassCount) {
        this.loadedClassCount = loadedClassCount;
    }

    public long getTotalloadedClassCount() {
        return totalloadedClassCount;
    }

    public void setTotalloadedClassCount(long totalloadedClassCount) {
        this.totalloadedClassCount = totalloadedClassCount;
    }

    public long getUnloadedCount() {
        return unloadedCount;
    }

    public void setUnloadedCount(long unloadedCount) {
        this.unloadedCount = unloadedCount;
    }
}
