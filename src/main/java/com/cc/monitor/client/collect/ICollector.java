package com.cc.monitor.client.collect;

public interface ICollector {

    public void collect() throws Exception;

    public int interval();

    public String key();

}
