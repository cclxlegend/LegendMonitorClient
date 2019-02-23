package com.cc.monitor.client.collect.vo;

import com.cc.monitor.client.annotation.QuotaParameter;
import com.cc.monitor.client.collect.AbstractQuotas;

public class JVMThreadQuotas extends AbstractQuotas {

    @QuotaParameter
    private int threadCount;

    @QuotaParameter
    private int deamonCount;

    @QuotaParameter
    private long totalStartedCount;

    @QuotaParameter
    private int newCount;

    @QuotaParameter
    private int runnableCount;

    @QuotaParameter
    private int blockedCount;

    @QuotaParameter
    private int waitingCount;

    @QuotaParameter
    private int timedWaitingCount;

    @QuotaParameter
    private int terminatedCount;

    @QuotaParameter
    private int deadLockedCount;

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getDeamonCount() {
        return deamonCount;
    }

    public void setDeamonCount(int deamonCount) {
        this.deamonCount = deamonCount;
    }

    public long getTotalStartedCount() {
        return totalStartedCount;
    }

    public void setTotalStartedCount(long totalStartedCount) {
        this.totalStartedCount = totalStartedCount;
    }

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public int getRunnableCount() {
        return runnableCount;
    }

    public void setRunnableCount(int runnableCount) {
        this.runnableCount = runnableCount;
    }

    public int getBlockedCount() {
        return blockedCount;
    }

    public void setBlockedCount(int blockedCount) {
        this.blockedCount = blockedCount;
    }

    public int getWaitingCount() {
        return waitingCount;
    }

    public void setWaitingCount(int waitingCount) {
        this.waitingCount = waitingCount;
    }

    public int getTimedWaitingCount() {
        return timedWaitingCount;
    }

    public void setTimedWaitingCount(int timedWaitingCount) {
        this.timedWaitingCount = timedWaitingCount;
    }

    public int getTerminatedCount() {
        return terminatedCount;
    }

    public void setTerminatedCount(int terminatedCount) {
        this.terminatedCount = terminatedCount;
    }

    public int getDeadLockedCount() {
        return deadLockedCount;
    }

    public void setDeadLockedCount(int deadLockedCount) {
        this.deadLockedCount = deadLockedCount;
    }
}
