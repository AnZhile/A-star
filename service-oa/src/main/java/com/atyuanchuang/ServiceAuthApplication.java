package com.atyuanchuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:38
 */
@SpringBootApplication
//@MapperScan("com.atyuanchuang.*.mapper")
//@ComponentScan("com.atyuanchuang")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
