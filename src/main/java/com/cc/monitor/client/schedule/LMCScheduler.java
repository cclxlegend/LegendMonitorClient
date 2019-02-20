package com.cc.monitor.client.schedule;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class LMCScheduler {

    private static Scheduler scheduler;

    private static void initScheduler() throws Exception{
       scheduler = StdSchedulerFactory.getDefaultScheduler();



    }

    /**
     *
     * @param jobName
     * @param group
     * @param clazz
     * @param interval 上报周期(秒)
     */
    public static void addJob(String jobName, String group, Class<Job> clazz, int interval) throws Exception{
        Trigger trigger = newTrigger().withIdentity("trigger-"+jobName, "group-"+jobName)
                .startNow()
                .withSchedule(simpleSchedule() //使用SimpleTrigger
                        .withIntervalInSeconds(interval) //每隔一秒执行一次
                        .repeatForever()) //一直执行，奔腾到老不停歇
                .build();
        JobDetail job = newJob(clazz)
                .withIdentity(jobName, jobName)
                .build();

        scheduler.scheduleJob(job, trigger);
    }

}
