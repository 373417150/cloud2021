package com.sss.springcloud.controller;

 import com.sss.springcloud.entity.CommonResult;
import com.sss.springcloud.entity.Payment;
import com.sss.springcloud.service.PaymentService;
//import lombok.Value;
  import lombok.extern.slf4j.Slf4j;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.cloud.client.ServiceInstance;
 import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

 import javax.annotation.Resource;
import java.util.List;


/**
 * @author:sss
 * @date:2020/4/12 20:47
 * @description:  @Resource是java提供的，@Autowired是spring提供的。
 * @version: 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
//    @RequestBody  需要加上注解才能插入成功  @RequestBody
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
         if(result > 0){
            return  new CommonResult(200,"插入成功,serverPort: " + serverPort,payment);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
         if(payment != null){
            return  new CommonResult(200,"查询成功======,serverPort: " + serverPort,payment);
        } else {
            return new CommonResult(444,"没有对应记录，查询ID: " + id,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
    @GetMapping(value="/payment/discover")
    public Object getDiscover(){
        List<String> services = discoveryClient.getServices();
        for (String ele:services) {
                log.info("element+++++"+ele);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ins:instances) {
            log.info("instances+++++"+ins.getServiceId()+"\t"+ins.getHost()+"\t"+ins.getPort()+"\t"+ins.getUri());
        }
        return this.discoveryClient;
    }
}



