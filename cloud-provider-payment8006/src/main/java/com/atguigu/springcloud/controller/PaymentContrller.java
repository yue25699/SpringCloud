package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("payment")
public class PaymentContrller {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("consul")
    public String paymentConsul(){
        return "springcloud with consul:" + serverPort +"\t" + UUID.randomUUID().toString();
    }
}
