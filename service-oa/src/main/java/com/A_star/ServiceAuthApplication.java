package com.A_star;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Anzhi
 * @data 2023/7/29 - 14:38
 */
@SpringBootApplication
//@MapperScan("com.A_star.*.mapper")
//@ComponentScan("com.A_star")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
