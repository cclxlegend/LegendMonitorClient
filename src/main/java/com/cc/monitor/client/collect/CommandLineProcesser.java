package com.cc.monitor.client.collect;

/**
 * 处理命令中每行数据的接口
 *
 * @author lishicheng
 */
@FunctionalInterface
public interface CommandLineProcesser {
    public int procLine(String line);
}
