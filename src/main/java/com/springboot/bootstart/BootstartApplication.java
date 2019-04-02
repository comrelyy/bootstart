package com.springboot.bootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * exclude和excludeName属性 关闭自动配置
 *
 */

@SpringBootApplication(exclude = {RedisAutoConfiguration.class},excludeName = {"RedisAutoConfiguration"})
//开启异步调用，也是就去支持@Async注解
@EnableAsync

//定时任务调度
@EnableScheduling

//开启缓存
@EnableCaching
public class BootstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstartApplication.class, args);

        /**
         *  SpringApplication springApplication = new SpringApplication(BootstartApplication.class);
         *  //通过SpringApplication暴露的方法进行自定义设置启动
         *  springApplication.run(args);
         *
         */

    }

}
