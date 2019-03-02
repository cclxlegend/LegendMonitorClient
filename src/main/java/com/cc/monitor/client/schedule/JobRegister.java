package com.cc.monitor.client.schedule;

import org.quartz.Job;

import java.util.HashSet;
import java.util.Set;

public final class JobRegister {

    private static Set<Class<? extends Job>> jobList;

    public static void regist(Class<? extends Job> jobClass) {
        if(jobList == null) {
            jobList = new HashSet<>();
        }
        jobList.add(jobClass);
    }

    protected static Set<Class<? extends Job>> getJobList(){
        return jobList;
    }
}
