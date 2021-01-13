package com.configClient.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        //http://localhost:3355/configInfo
        return "serverPort"+serverPort+"===" +configInfo;
    }
}