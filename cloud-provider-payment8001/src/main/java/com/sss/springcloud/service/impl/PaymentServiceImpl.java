package com.sss.springcloud.service.impl;

import com.sss.springcloud.dao.PaymentDao;
import com.sss.springcloud.entity.Payment;
import com.sss.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:sss
 * @date:2020/4/12 20:45
 * @description:
 * @version: 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
