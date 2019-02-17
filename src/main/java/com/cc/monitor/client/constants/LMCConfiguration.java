package com.cc.monitor.client.constants;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LMCConfiguration {

    static {
        load();
    }

    private static Properties props = new Properties();

    private static void load(){
        InputStream in = LMCConfiguration.class.getClassLoader().getResourceAsStream("monitor_client.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key,String defaultValue){
        String val = props.getProperty(key);

        if(StringUtils.isEmpty(val)){
            return defaultValue;
        }
        return val;
    }

}
