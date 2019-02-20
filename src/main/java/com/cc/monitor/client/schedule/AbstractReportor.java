package com.cc.monitor.client.schedule;

import java.util.Map;

public abstract class AbstractReportor{

    protected abstract void report(String url, Map<String,Object> params);
}
