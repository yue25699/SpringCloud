package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("comsumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYENT_URL = "http://cloud-payment-service";

    @GetMapping("payment/zk")
    public String getpaymentInfo() {
        String res = restTemplate.getForObject(PAYENT_URL+"/payment/zk",String.class);
        return res;
    }
}
