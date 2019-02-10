package com.cc.monitor.client.collect.sys.impl;

import com.cc.monitor.client.collect.sys.AbstractSysCollector;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MacCollector extends AbstractSysCollector {

    public MacCollector() {

    }

    public void collect() throws Exception {
        InputStream in = null;
        Process process = null;
        process = Runtime.getRuntime().exec("top");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
        String line = null;
        while((line = reader.readLine())!=null){
            if(!procLine(line)){
                break;
            }
        }
    }

    @Override
    public boolean procLine(String line) {


        return false;
    }
}
