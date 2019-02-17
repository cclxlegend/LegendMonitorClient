package com.cc.monitor.client.schedule;

import java.util.*;

public class TaskList {

    private static List<String> singletonTaskList = new ArrayList<>();
    private static List<String> taskList = new ArrayList<>();

    static {
        initTasklist();
    }

    /**
     * 初始化定时任务列表
     */
    private static void initTasklist(){
        Properties sysProps = System.getProperties();
        // 添加心跳采集器

        // 添加系统信息采集器
        String osName = sysProps.getProperty("os.name");

        // 添加JVM采集器

        // 添加其他采集器

    }

    public static List<String> getTaskList(){
        return taskList;
    }

    public static List<String> getSingletonTaskList(){
        return singletonTaskList;
    }

    public static void main(String args[]){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
