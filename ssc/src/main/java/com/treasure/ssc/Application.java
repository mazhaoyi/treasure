package com.treasure.ssc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author: mazy
 * @date: 2018/4/19 14:06
 */
@SpringBootApplication
@MapperScan(value = {"com.treasure.ssc.dao", "com.treasure.mbgenerator.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
