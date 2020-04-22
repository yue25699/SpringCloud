package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("info/ok/{id}")
    public String getPaymentInfo_OK(@PathVariable("id") Integer id){
        String res = paymentService.getPaymentInfo_OK(id);
        return res;
    }
    @GetMapping("info/error/{id}")
    public String getPaymentInfo_Error(@PathVariable("id") Integer id){
        String res = paymentService.getPaymentInfo_Error(id);
        return res;
    }

    @GetMapping("info/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String res = paymentService.paymentCircuitBreaker(id);
        return res;
    }


}
