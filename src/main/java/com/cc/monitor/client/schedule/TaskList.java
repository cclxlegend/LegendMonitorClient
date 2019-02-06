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
        if(osName.contains("Mac") || osName.contains("mac")) {
            singletonTaskList.add("sys-mac");
            taskList.add("sys-mac");
        }else if(osName.contains("Windows") || osName.contains("windows")){
            singletonTaskList.add("sys-winows");
            taskList.add("sys-winows");
        }else if(osName.contains("Linux") || osName.contains("linux")){
            singletonTaskList.add("sys-linux");
            taskList.add("sys-linux");
        }
        // 添加JVM采集器

        // 添加其他采集器

    }

    public static List<String> getTaskList(){
        return taskList;
    }

    public static List<String> getSingletonTaskList(){
        return singletonTaskList;
    }
}
