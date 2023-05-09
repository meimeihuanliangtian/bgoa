package com.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.atguigu.common.config","com.example"})
@Slf4j
@MapperScan("com.example.mapper")
public class ServiceYApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceYApplication.class, args);
        log.info("springboot启动成功");
    }
}
