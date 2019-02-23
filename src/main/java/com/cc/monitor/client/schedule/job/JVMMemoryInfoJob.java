package com.cc.monitor.client.schedule.job;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.schedule.AbstractReportor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static com.cc.monitor.client.constants.LMCConstants.JVM_MEMORY_URL;

public class JVMMemoryInfoJob extends AbstractReportor implements Job {

    @Autowired
    @Qualifier("jvmMemoryInfoCollector")
    public ICollector collector;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            report(JVM_MEMORY_URL, collector.collect());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
