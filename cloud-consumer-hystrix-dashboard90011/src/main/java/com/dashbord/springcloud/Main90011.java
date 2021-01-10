package com.dashbord.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class Main90011 {


        public static void main(String[] args) {
            SpringApplication.run(Main90011.class, args);
        }


}
