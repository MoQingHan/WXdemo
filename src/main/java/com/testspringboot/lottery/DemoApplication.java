package com.testspringboot.lottery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement//开启事务管理
@ServletComponentScan//filter扫描器
@SpringBootApplication//springboot启动类启动类必须
@EnableScheduling//开启spring定时器
@MapperScan("com.testspringboot.lottery.dao")//mybatis Mapper扫描器
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

