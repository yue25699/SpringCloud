package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.fallback.PaymentFallbackHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT",fallback = PaymentFallbackHystrixService.class)
public interface PaymentHystrixService {

    @GetMapping("payment/info/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("payment/info/error/{id}")
    String paymentInfo_ERROR(@PathVariable("id") Integer id);
}
