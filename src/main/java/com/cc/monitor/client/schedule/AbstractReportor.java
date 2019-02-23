package com.cc.monitor.client.schedule;

import com.cc.monitor.client.util.HttpClient;

import java.util.Map;

public abstract class AbstractReportor{

    protected final void report(String url, Map<String,Object> params) throws Exception{
        HttpClient.post(url, params);
    }
}
