package com.atguigu.springcloud.service;

public interface PaymentService {

    String getPaymentInfo_OK(Integer id);
    String getPaymentInfo_Error(Integer id);
    String paymentCircuitBreaker(Integer id);
}
