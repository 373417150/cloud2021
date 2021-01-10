package com.sss.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 负载均衡规则
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
            // 定义为随机
            return new RandomRule();
    }
}
