package com.springconfig.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344
{
    public static void main(String[] args) {
        //http://lconfig-3344.com:3344/config-dev.yml
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}

