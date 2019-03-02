package com.cc.monitor.client.biz;

import com.cc.monitor.client.constants.LMCConstants;
import com.cc.monitor.client.util.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cc.monitor.client.constants.LMCConstants.*;

/**
 * 上报自定义业务指标
 */
public class LMCBizReportor {

    public static void reportBizQuota(String quotaKey) {
        Map<String,Object> params = new HashMap<>();
        params.put("device.name", LMCConstants.DEVICE_NAME);
        params.put("device.key", LMCConstants.DEVICE_KEY);
        params.put("app.name", LMCConstants.APP_NAME);

        Map<String,Object> contentMap = new HashMap<>();
        contentMap.put(quotaKey, 1);

        params.put("quotas", contentMap);

        try {
            HttpClient.post(BIZ_NORMAL_URL, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reportBizQuota(String quotaKey, long value) {
        Map<String,Object> params = new HashMap<>();
        params.put("device.name", LMCConstants.DEVICE_NAME);
        params.put("device.key", LMCConstants.DEVICE_KEY);
        params.put("app.name", LMCConstants.APP_NAME);

        Map<String,Object> contentMap = new HashMap<>();
        contentMap.put(quotaKey, value);

        params.put("quotas", contentMap);

        try {
            HttpClient.post(BIZ_NORMAL_URL, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reportBizQuota(Map<String,Long> quotaMap) {
        Map<String,Object> params = new HashMap<>();
        params.put("device.name", LMCConstants.DEVICE_NAME);
        params.put("device.key", LMCConstants.DEVICE_KEY);
        params.put("app.name", LMCConstants.APP_NAME);

        Map<String,Object> contentMap = new HashMap<>();
        contentMap.putAll(quotaMap);

        params.put("quotas", contentMap);

        try {
            HttpClient.post(BIZ_NORMAL_URL, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
