package com.hystrix.springcloud.controller;

import com.hystrix.springcloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
//全局的降级方法
 @DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class HystrixController {

    @Resource
    private HystrixService hystrixService;


    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id){
       String value= hystrixService.paymentInfo_OK(id);
       return "80消费++++++"+value;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_hander",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "3000")//3秒  正常访问时间  超时后降级处理
//    }) //服务 异常报错  也会降级处理
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id) {

         int timeNumbers =10/0;
        String value= hystrixService.paymentInfo_TimeOut(id);
        return  value;
    }

    //降级处理方法
    public String paymentInfo_TimeOut_hander(Integer id) {
        return " 80消费  线程池:"+"对方服务繁忙，或程序出错" + id + "\t" +
                " 系统繁忙。。。。稍后再试" ;
    }



    // 全局  降级处理

    public String payment_Global_FallbackMethod() {
        return " 80消费 全局降级处理方法"+"Global_Error,请稍等再试" ;
    }
}
