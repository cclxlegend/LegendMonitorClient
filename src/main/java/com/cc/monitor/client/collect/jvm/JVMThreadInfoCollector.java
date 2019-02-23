package com.cc.monitor.client.collect.jvm;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.QuotasFactory;
import com.cc.monitor.client.collect.vo.JVMThreadQuotas;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;

@Component("jvmThreadInfoCollector")
public class JVMThreadInfoCollector implements ICollector {
    @Override
    public Map<String, Object> collect() throws Exception {
        JVMThreadQuotas quotas = QuotasFactory.getJVMThreadQuotas();
        final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        quotas.setThreadCount(threadBean.getThreadCount());
        quotas.setDeamonCount(threadBean.getDaemonThreadCount());
        quotas.setTotalStartedCount(threadBean.getTotalStartedThreadCount());

        ThreadInfo[] threadInfos = threadBean.getThreadInfo(threadBean.getAllThreadIds());

        int newThreadCount = 0;
        int runnableThreadCount = 0;
        int blockedThreadCount = 0;
        int waitThreadCount = 0;
        int timeWaitThreadCount = 0;
        int terminatedThreadCount = 0;

        if (threadInfos != null) {
            for (ThreadInfo threadInfo : threadInfos) {
                if (threadInfo != null) {
                    switch (threadInfo.getThreadState()) {
                        case NEW:
                            newThreadCount++;
                            break;
                        case RUNNABLE:
                            runnableThreadCount++;
                            break;
                        case BLOCKED:
                            blockedThreadCount++;
                            break;
                        case WAITING:
                            waitThreadCount++;
                            break;
                        case TIMED_WAITING:
                            timeWaitThreadCount++;
                            break;
                        case TERMINATED:
                            terminatedThreadCount++;
                            break;
                        default:
                            break;
                    }
                } else {
                    /**
                     * If a thread of a given ID is not alive or does not exist, the corresponding element in the returned array will,
                     * contain null,because is mut exist ,so the thread is terminated
                     */
                    terminatedThreadCount++;
                }
            }
        }

        quotas.setNewCount(newThreadCount);
        quotas.setRunnableCount(runnableThreadCount);
        quotas.setBlockedCount(blockedThreadCount);
        quotas.setWaitingCount(waitThreadCount);
        quotas.setTimedWaitingCount(timeWaitThreadCount);
        quotas.setTerminatedCount(terminatedThreadCount);

        long[] deadLockedIds = threadBean.findDeadlockedThreads();
        if (deadLockedIds == null) {
            quotas.setDeadLockedCount(0);
        } else {
            quotas.setTerminatedCount(deadLockedIds.length);
        }

        return quotas.generateParams();
    }

}
