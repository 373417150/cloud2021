package com.sss.springcloud.controller;

import com.sss.springcloud.entity.CommonResult;
import com.sss.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author:sss
 * @date:2020/4/12 22:42
 * @description:
 * @version: 1.0.0
 */
@RestController
@Slf4j
public class OrderConsulController {
    //  单机版
//    public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://consul-provider-pament";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consul() {
         return "消费者调用："+restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }


}


