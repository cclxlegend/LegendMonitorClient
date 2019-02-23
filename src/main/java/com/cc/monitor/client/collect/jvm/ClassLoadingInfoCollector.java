package com.cc.monitor.client.collect.jvm;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.QuotasFactory;
import com.cc.monitor.client.collect.vo.ClassLoadingQuotas;
import org.springframework.stereotype.Component;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.Map;

@Component("classLoadingInfoCollector")
public class ClassLoadingInfoCollector implements ICollector {

    @Override
    public Map<String, Object> collect() throws Exception {

        ClassLoadingQuotas quotas = QuotasFactory.getClassLoadingQuotas();
        final ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();

        quotas.setLoadedClassCount(classLoadingMXBean.getLoadedClassCount());
        quotas.setTotalloadedClassCount(classLoadingMXBean.getTotalLoadedClassCount());
        quotas.setUnloadedCount(classLoadingMXBean.getUnloadedClassCount());

        return quotas.generateParams();

    }
}
