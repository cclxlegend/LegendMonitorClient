package com.cc.monitor.client.biz;

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
        params.put("device" , DEVICE_NAME);
        params.put("app" , APP_NAME);
        params.put(quotaKey, 1);

        try {
            HttpClient.post(BIZ_NORMAL_URL, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reportBizQuota(String quotaKey, long value) {
        Map<String,Object> params = new HashMap<>();
        params.put("device" , DEVICE_NAME);
        params.put("app" , APP_NAME);
        params.put(quotaKey, value);

        try {
            HttpClient.post(BIZ_NORMAL_URL, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
