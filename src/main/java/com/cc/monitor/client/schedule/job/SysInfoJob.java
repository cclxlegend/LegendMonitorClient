package com.cc.monitor.client.schedule.job;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.schedule.AbstractReportor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

public class SysInfoJob extends AbstractReportor implements Job {

    @Autowired
    @Qualifier("sysCollector")
    public ICollector collector;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }

    @Override
    protected void report(String url, Map<String, Object> params) {

    }
}
