package com.cc.monitor.client.collect.jvm;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.QuotasFactory;
import com.cc.monitor.client.collect.vo.GCQuotas;
import com.cc.monitor.client.constants.GCAlgorithm;
import com.cc.monitor.client.exception.LMCMonitorException;
import org.springframework.stereotype.Component;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Map;

@Component("gcInfoCollector")
public class GCInfoCollector implements ICollector {

    @Override
    public Map<String, Object> collect() throws Exception {

        GCQuotas quotas = QuotasFactory.getGCQuotas();

        long gcCount = 0;
        long gcTime = 0;
        long oldGCount = 0;
        long oldGcTime = 0;
        long youngGcCount = 0;
        long youngGcTime = 0;

        for (final GarbageCollectorMXBean garbageCollector : ManagementFactory.getGarbageCollectorMXBeans()) {
            gcTime += garbageCollector.getCollectionTime();
            gcCount += garbageCollector.getCollectionCount();
            String gcAlgorithm = garbageCollector.getName();

            if (GCAlgorithm.isYoungGcAlgorithm(gcAlgorithm)) {
                youngGcTime += garbageCollector.getCollectionTime();
                youngGcCount += garbageCollector.getCollectionCount();
            } else if (GCAlgorithm.isOldGcAlgorithm(gcAlgorithm)) {
                oldGcTime += garbageCollector.getCollectionTime();
                oldGCount += garbageCollector.getCollectionCount();
            } else {
                throw new LMCMonitorException("未知的GC算法");
            }
        }

        quotas.setGcCount(gcCount);
        quotas.setGcTime(gcTime);
        quotas.setFullGcCount(oldGCount);
        quotas.setFullGcTime(oldGcTime);
        quotas.setYoungGcCount(youngGcCount);
        quotas.setYoungGcTime(youngGcTime);

        return quotas.generateParams();
    }
}
