package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.annotation.QuotaParameter;
import com.cc.monitor.client.collect.AbstractQuotas;

public class JVMMemoryQuotas extends AbstractQuotas {

    @QuotaParameter
    private long usedHeapMemory;

    @QuotaParameter
    private long maxHeapMemory;

    @QuotaParameter
    private long usedOldGen;

    @QuotaParameter
    private long maxOldGen;

    @QuotaParameter(rejectIfNull = true)
    private long usedPermGen;

    @QuotaParameter(rejectIfNull = true)
    private long maxPermGen;

    @QuotaParameter
    private long usedEdenSpace;

    @QuotaParameter
    private long maxEdenSpace;

    @QuotaParameter
    private long usedSurvivorSpace;

    @QuotaParameter
    private long maxSurvivorSpace;

    @QuotaParameter(rejectIfNull = true)
    private long usedMetaSpace;

    @QuotaParameter(rejectIfNull = true)
    private long maxMetaSpace;

    @QuotaParameter(rejectIfNull = true)
    private long usedNonHeapMemory;

    @QuotaParameter(rejectIfNull = true)
    private long maxNonHeapMemory;

    @QuotaParameter(rejectIfNull = true)
    private long usedCodeCacheMemory;

    @QuotaParameter(rejectIfNull = true)
    private long maxCodeCacheMemory;

    public long getUsedHeapMemory() {
        return usedHeapMemory;
    }

    public void setUsedHeapMemory(long usedHeapMemory) {
        this.usedHeapMemory = usedHeapMemory;
    }

    public long getMaxHeapMemory() {
        return maxHeapMemory;
    }

    public void setMaxHeapMemory(long maxHeapMemory) {
        this.maxHeapMemory = maxHeapMemory;
    }

    public long getUsedOldGen() {
        return usedOldGen;
    }

    public void setUsedOldGen(long usedOldGen) {
        this.usedOldGen = usedOldGen;
    }

    public long getMaxOldGen() {
        return maxOldGen;
    }

    public void setMaxOldGen(long maxOldGen) {
        this.maxOldGen = maxOldGen;
    }

    public long getUsedPermGen() {
        return usedPermGen;
    }

    public void setUsedPermGen(long usedPermGen) {
        this.usedPermGen = usedPermGen;
    }

    public long getMaxPermGen() {
        return maxPermGen;
    }

    public void setMaxPermGen(long maxPermGen) {
        this.maxPermGen = maxPermGen;
    }

    public long getUsedEdenSpace() {
        return usedEdenSpace;
    }

    public void setUsedEdenSpace(long usedEdenSpace) {
        this.usedEdenSpace = usedEdenSpace;
    }

    public long getMaxEdenSpace() {
        return maxEdenSpace;
    }

    public void setMaxEdenSpace(long maxEdenSpace) {
        this.maxEdenSpace = maxEdenSpace;
    }

    public long getUsedSurvivorSpace() {
        return usedSurvivorSpace;
    }

    public void setUsedSurvivorSpace(long usedSurvivorSpace) {
        this.usedSurvivorSpace = usedSurvivorSpace;
    }

    public long getMaxSurvivorSpace() {
        return maxSurvivorSpace;
    }

    public void setMaxSurvivorSpace(long maxSurvivorSpace) {
        this.maxSurvivorSpace = maxSurvivorSpace;
    }

    public long getUsedMetaSpace() {
        return usedMetaSpace;
    }

    public void setUsedMetaSpace(long usedMetaSpace) {
        this.usedMetaSpace = usedMetaSpace;
    }

    public long getMaxMetaSpace() {
        return maxMetaSpace;
    }

    public void setMaxMetaSpace(long maxMetaSpace) {
        this.maxMetaSpace = maxMetaSpace;
    }

    public long getUsedNonHeapMemory() {
        return usedNonHeapMemory;
    }

    public void setUsedNonHeapMemory(long usedNonHeapMemory) {
        this.usedNonHeapMemory = usedNonHeapMemory;
    }

    public long getMaxNonHeapMemory() {
        return maxNonHeapMemory;
    }

    public void setMaxNonHeapMemory(long maxNonHeapMemory) {
        this.maxNonHeapMemory = maxNonHeapMemory;
    }

    public long getUsedCodeCacheMemory() {
        return usedCodeCacheMemory;
    }

    public void setUsedCodeCacheMemory(long usedCodeCacheMemory) {
        this.usedCodeCacheMemory = usedCodeCacheMemory;
    }

    public long getMaxCodeCacheMemory() {
        return maxCodeCacheMemory;
    }

    public void setMaxCodeCacheMemory(long maxCodeCacheMemory) {
        this.maxCodeCacheMemory = maxCodeCacheMemory;
    }
}
