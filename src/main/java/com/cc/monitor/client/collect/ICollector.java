package com.cc.monitor.client.collect;

import java.util.Map;

public interface ICollector {

    public Map<String,Object> collect() throws Exception;

    public String key();

}
