package com.sss.springcloud.dao;

import com.sss.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:sss
 * @date:2020/4/12 20:24
 * @description: 操作数据库
 * @Mapper与@ @Repository两个都行，建议使用mapper，避免一些错误
 * @version: 1.0.0
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}