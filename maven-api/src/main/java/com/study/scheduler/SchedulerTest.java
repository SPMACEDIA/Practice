package com.study.scheduler;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

public class SchedulerTest {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            String jobName = "第一个定时任务";
            String TRIGGER_GROUP_NAME = "TRIGGER_GROUP_NAME";
            String time ="* * * * * ?";
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = new JobDetail(jobName, TRIGGER_GROUP_NAME, QuartzJob.class);
            //
            CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);
            // 触发器名,触发器组
            trigger.setCronExpression(time);
            // 触发器时间设定
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
