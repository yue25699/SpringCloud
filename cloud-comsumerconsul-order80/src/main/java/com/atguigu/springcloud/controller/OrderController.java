package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {

    final private String INVOKE_URL="http://consul-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/consul")
    public String getPaymentInfo() {
        String info = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return info;
    }
}
