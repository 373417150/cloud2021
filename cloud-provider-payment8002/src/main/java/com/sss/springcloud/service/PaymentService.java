package com.sss.springcloud.service;

import com.sss.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author:sss
 * @date:2020/4/12 20:44
 * @description:
 * @version: 1.0.0
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}

