package com.consul.springcloud.controller;

import cn.hutool.core.lang.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class paymentConsulController {

    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value="/payment/consul")

    public String consul() {

       return  "springcloud with consul ===== erverPort: " + serverPort+"\t"+ UUID.randomUUID().toString();

    }
}
