package com.haiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//SpringBoot项目启动类，这个注解是SpringBoot最重要的注解
@SpringBootApplication
//让Springboot开启定时任务注解功能支持
@EnableScheduling
public class BlogSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSystemApplication.class, args);
    }

}
