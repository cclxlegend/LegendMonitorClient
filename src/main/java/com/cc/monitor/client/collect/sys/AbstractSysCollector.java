package com.cc.monitor.client.collect.sys;

import com.cc.monitor.client.collect.ICollector;

import static com.cc.monitor.client.constants.LMCConstants.SYS_JOB_INTERVAL;

public abstract class AbstractSysCollector implements ICollector {

    @Override
    public int interval() {
        return SYS_JOB_INTERVAL;
    }

    @Override
    public String key() {
        return "sys";
    }
}
