package com.cc.monitor.client.collect;

public interface ICollector {

    public void collect();

    public int interval();

    public String key();

}
