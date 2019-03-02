package com.cc.monitor.client.schedule;

import com.cc.monitor.client.annotation.LMCReportor;
import com.cc.monitor.client.exception.LMCMonitorException;
import com.cc.monitor.client.schedule.job.SysInfoJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class LMCScheduler {

    private static Scheduler scheduler;

    private static void initScheduler() throws LMCMonitorException {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            // 添加默认定时任务
            addJob("sysInfo", "sys", SysInfoJob.class, 5);
            addJob("jvm-classloading", "jvm", SysInfoJob.class, 60);
            addJob("jvm-gc", "jvm", SysInfoJob.class, 60);
            addJob("jvm-memory", "jvm", SysInfoJob.class, 60);
            addJob("jvm-thread", "jvm", SysInfoJob.class, 60);
            // 扫描用户自定义定时任务
        } catch (Exception e) {
            e.printStackTrace();
            throw new LMCMonitorException(e, "添加默认定时上报任务时发生异常");
        }

        try {
            // 添加用户注册过的自定义定时任务
            for (Class clazz : JobRegister.getJobList()) {
                LMCReportor reportorAttr = (LMCReportor) clazz.getAnnotation(LMCReportor.class);
                if (reportorAttr == null) {
                    // 不处理没加注解的类
                    continue;
                }
                String name = reportorAttr.name();
                String group = name;

                int interval = reportorAttr.interval();
                int delay = reportorAttr.delay();

                if (delay == 0) {
                    addJob(name, group, clazz, interval);
                } else {
                    addDelayJob(name, group, clazz, interval, delay);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    /**
     * @param jobName
     * @param group
     * @param clazz
     * @param interval 上报周期(秒)
     */
    private static void addJob(String jobName, String group, Class<? extends Job> clazz, int interval) throws Exception {
        Trigger trigger = newTrigger().withIdentity("trigger-" + jobName, "group-" + jobName)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(interval)
                        .repeatForever())
                .build();
        JobDetail job = newJob(clazz)
                .withIdentity(jobName, jobName)
                .build();

        scheduler.scheduleJob(job, trigger);
    }

    /**
     * @param jobName
     * @param group
     * @param clazz
     * @param interval 上报周期(秒)
     * @param delay    延时启动(秒)
     * @throws Exception
     */
    private static void addDelayJob(String jobName, String group, Class<Job> clazz, int interval, int delay) throws Exception {
        Date startDate = DateBuilder.futureDate(delay, DateBuilder.IntervalUnit.SECOND);
        Trigger trigger = newTrigger().withIdentity("trigger-" + jobName, "group-" + jobName)
                .startAt(startDate)
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(interval)
                        .repeatForever())
                .build();
        JobDetail job = newJob(clazz)
                .withIdentity(jobName, jobName)
                .build();

        scheduler.scheduleJob(job, trigger);
    }

    public static void start(){
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
