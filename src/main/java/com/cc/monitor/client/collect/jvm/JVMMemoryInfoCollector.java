package com.cc.monitor.client.collect.jvm;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.QuotasFactory;
import com.cc.monitor.client.collect.vo.JVMMemoryQuotas;
import com.cc.monitor.client.exception.LMCMonitorException;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.Map;

@Component("jvmMemoryInfoCollector")
public class JVMMemoryInfoCollector implements ICollector {

    @Override
    public Map<String, Object> collect() throws Exception {
        JVMMemoryQuotas quotas = QuotasFactory.getJVMMemoryQuotas();
        quotas.setUsedHeapMemory(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        quotas.setMaxHeapMemory(Runtime.getRuntime().maxMemory());

        // 统计伊甸园
        final MemoryPoolMXBean edenSpaceMemoryPool = getEdenSpacePool();
        if (edenSpaceMemoryPool != null) {
            final MemoryUsage usage = edenSpaceMemoryPool.getUsage();
            quotas.setUsedEdenSpace(usage.getUsed());
            quotas.setMaxEdenSpace(usage.getMax());
        } else {
            throw new LMCMonitorException("无法访问伊甸园内存信息");
        }

        // 统计存活区
        final MemoryPoolMXBean survivorSpacePool = getSurvivorSpaceMemoryPool();
        if (survivorSpacePool != null) {
            final MemoryUsage usage = survivorSpacePool.getUsage();
            quotas.setUsedSurvivorSpace(usage.getUsed());
            quotas.setMaxSurvivorSpace(usage.getMax());
        } else {
            throw new LMCMonitorException("无法访问存活区内存信息");
        }

        //统计老年代
        final MemoryPoolMXBean oldGenMemoryPool = getOldGenMemoryPool();
        if (oldGenMemoryPool != null) {
            final MemoryUsage usage = oldGenMemoryPool.getUsage();
            quotas.setUsedOldGen(usage.getUsed());
            quotas.setMaxOldGen(usage.getMax());
        } else {
            throw new LMCMonitorException("无法访问老年代内存信息");
        }

        // 统计永久代/元空间
        final MemoryPoolMXBean permGenMemoryPool = getPermGenMemoryPool();
        final MemoryPoolMXBean metaSpaceMemoryPool = getMetaspaceMemoryPool();
        if (permGenMemoryPool == null && metaSpaceMemoryPool == null) {
            throw new LMCMonitorException("无法访问永久带/元空间内存信息");
        } else if(permGenMemoryPool!=null){
            final MemoryUsage usage = permGenMemoryPool.getUsage();
            quotas.setUsedPermGen(usage.getUsed());
            quotas.setMaxPermGen(usage.getMax());
        }else if (metaSpaceMemoryPool !=null){
            final MemoryUsage usage = metaSpaceMemoryPool.getUsage();
            quotas.setUsedMetaSpace(usage.getUsed());
            quotas.setMaxMetaSpace(usage.getMax());
        }

        // 统计JIT编译内存空间
        final MemoryPoolMXBean codeCacheMemoryPool = getCodeCacheMemoryPool();
        if (codeCacheMemoryPool != null) {
            final MemoryUsage usage = codeCacheMemoryPool.getUsage();
            quotas.setUsedCodeCacheMemory(usage.getUsed());
            quotas.setMaxCodeCacheMemory(usage.getMax());
        }

        //统计非堆
        final MemoryUsage nonHeapMemoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        quotas.setUsedNonHeapMemory(nonHeapMemoryUsage.getUsed());
        quotas.setMaxNonHeapMemory(nonHeapMemoryUsage.getMax());

        return quotas.generateParams();
    }

    private MemoryPoolMXBean getMetaspaceMemoryPool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Metaspace")) {
                return memoryPool;
            }
        }
        return null;
    }

    private MemoryPoolMXBean getOldGenMemoryPool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Old Gen")) {
                return memoryPool;
            }
        }
        return null;
    }

    private MemoryPoolMXBean getPermGenMemoryPool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Perm Gen")) {
                return memoryPool;
            }
        }
        return null;
    }

    private MemoryPoolMXBean getSurvivorSpaceMemoryPool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Survivor Space")) {
                return memoryPool;
            }
        }
        return null;
    }

    private MemoryPoolMXBean getCodeCacheMemoryPool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Code Cache")) {
                return memoryPool;
            }
        }
        return null;
    }

    private MemoryPoolMXBean getEdenSpacePool() {
        for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (memoryPool.getName().endsWith("Eden Space")) {
                return memoryPool;
            }
        }
        return null;
    }
}
