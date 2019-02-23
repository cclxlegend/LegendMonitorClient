package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.annotation.QuotaParameter;

public class JVMMemoryQuotas {

    @QuotaParameter
    private long uesdHeapMemory;

    @QuotaParameter
    private long maxHeapMemory;

    @QuotaParameter
    private long usedOldGen;

    @QuotaParameter
    private long maxOldGen;

    @QuotaParameter
    private long uesdPermGen;

    @QuotaParameter
    private long maxPermGen;

    @QuotaParameter
    private long usedEdenSpace;

    @QuotaParameter
    private long maxEdenSpace;

    @QuotaParameter
    private long usedSurvivorSpace;

    @QuotaParameter
    private long maxSurvivorSpace;

    @QuotaParameter
    private long usedMetaSpace;

    @QuotaParameter
    private long maxMetaSpace;

    @QuotaParameter
    private long usedNonHeapMemory;

    @QuotaParameter
    private long maxNonHeapMemory;



}
