package com.springboot.bootstart.quartz;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 调度任务 1s中执行一次
 */
//@Component
public class MyJob {

    @Scheduled(fixedRate = 1000)
    public void run(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
