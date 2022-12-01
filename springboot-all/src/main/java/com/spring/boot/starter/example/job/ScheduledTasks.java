package com.spring.boot.starter.example.job;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    /**
     * @Scheduled详解
     @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     @Scheduled(cron="") ：通过cron表达式定义规则
     **/
    //@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("现在时间：{}",dateFormat.format(new Date()));
    }


}
