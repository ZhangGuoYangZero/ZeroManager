package com.manager.mag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan("com.manager.mag.dao")//扫描dao层的所有接口类，帮助MAPPER去实例化给ioc
@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
}
