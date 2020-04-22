package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("selectOne/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("/feign/timeout")
    public String getFeignTimeOut() {
        return paymentFeignService.getFeignTimeOut();
    }
}
