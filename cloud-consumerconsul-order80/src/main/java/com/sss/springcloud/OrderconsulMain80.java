package com.sss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:sss
 * @date:2020/4/12 22:39
 * @description:
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderconsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderconsulMain80.class,args);
    }
}


