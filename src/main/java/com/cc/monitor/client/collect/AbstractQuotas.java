package com.cc.monitor.client.collect;

import com.cc.monitor.client.annotation.QuotaParameter;
import com.cc.monitor.client.constants.LMCConstants;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractQuotas {

    public Map<String, Object> generateParams() {

        Map<String, Object> params = new HashMap<>();
        try {
            params.put("device.name", LMCConstants.DEVICE_NAME);
            params.put("device.key", LMCConstants.DEVICE_KEY);
            params.put("app.name", LMCConstants.APP_NAME);

            Map<String, Object> contentMap = new HashMap<>();
            Class clazz = this.getClass();
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                QuotaParameter quotaParameter = field.getAnnotation(QuotaParameter.class);
                if (quotaParameter == null) {
                    continue;
                }
                field.setAccessible(true);
                String name = quotaParameter.name();
                name = StringUtils.isEmpty(name) ? field.getName() : name;

                Object value = field.get(this);
                if (value == null) {
                    if (quotaParameter.rejectIfNull()) {
                        continue;
                    }
                }
                contentMap.put(name, value);
            }
            params.put("quotas", contentMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return params;
    }
}
