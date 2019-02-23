package com.cc.monitor.client.constants;

import com.cc.monitor.client.util.IpUtil;
import org.apache.commons.lang3.StringUtils;

public class LMCConstants {

    public static final int SOCKET_TIMEOUT = 3000;
    public static final int CONN_TIMEOUT = 5000;

    // 系统信息采集定时任务执行间隔 (秒)
    public static final int SYS_JOB_INTERVAL = 5;
    // 采集上报心跳定时任务的执行间隔 （秒）
    public static final int HEARTBEAT_INTERVAL = 5;

    public static final int YOUNG_GC = 0;

    public static final int OLD_GC = 1;

    public static final String IP = IpUtil.getLocalIp();

    public static final String DEVICE_NAME = LMCConfiguration.getString("device.name","unkownDevice@"+IP);

    public static final String APP_NAME = LMCConfiguration.getString("app.name","unkownApp");

    public static final String[] REPORTOR_SCAN_PATH = LMCConfiguration.getString("reportor.scan.path", StringUtils.EMPTY).split(",");

    public static final String LMC_BASE_URL = LMCConfiguration.getString("lmc.url","localhost:8080");

    public static final String SYS_URL = LMC_BASE_URL + "/sys/all";

    public static final String HEARTBEAT_URL =LMC_BASE_URL + "/sys/heartbeat";
}
