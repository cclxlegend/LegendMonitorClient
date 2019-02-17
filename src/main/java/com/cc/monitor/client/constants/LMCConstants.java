package com.cc.monitor.client.constants;

import com.cc.monitor.client.util.IpUtil;

public class LMCConstants {

    // 系统信息采集定时任务执行间隔 (秒)
    public static final int SYS_JOB_INTERVAL = 5;
    // 采集上报心跳定时任务的执行间隔 （秒）
    public static final int HEARTBEAT_INTERVAL = 5;

    public static final String IP = IpUtil.getLocalIp();

    public static final String DEVICE_NAME = LMCConfiguration.getString("device.name","unkownApp@"+IP);


}
