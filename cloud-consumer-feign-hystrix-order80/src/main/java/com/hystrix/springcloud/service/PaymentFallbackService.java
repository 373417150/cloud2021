package com.hystrix.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements HystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService===paymentInfo_OK  error";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService===paymentInfo_TimeOut  error";
    }
}
