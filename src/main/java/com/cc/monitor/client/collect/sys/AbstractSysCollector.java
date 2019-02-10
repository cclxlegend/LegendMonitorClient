package com.cc.monitor.client.collect.sys;

import com.cc.monitor.client.collect.ICollector;
import com.cc.monitor.client.collect.vo.SysQuotas;

import static com.cc.monitor.client.constants.LMCConstants.SYS_JOB_INTERVAL;

public abstract class AbstractSysCollector implements ICollector {

    protected SysQuotas quotas = SysQuotas.getInstance();

    public AbstractSysCollector(){

    }

    public abstract boolean procLine(String line);

    public int interval() {
        return SYS_JOB_INTERVAL;
    }

    public String key() {
        return "sys";
    }
}
