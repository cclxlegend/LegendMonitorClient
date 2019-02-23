package com.cc.monitor.client.collect.jvm;

import com.cc.monitor.client.collect.ICollector;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("classLoadingInfoCollector")
public class ClassLoadingInfoCollector implements ICollector{

    @Override
    public Map<String, Object> collect() throws Exception {
        return null;
    }

    @Override
    public String key() {
        return "jvm-classloading";
    }
}
