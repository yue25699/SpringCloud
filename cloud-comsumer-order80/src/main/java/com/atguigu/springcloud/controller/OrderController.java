package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalaner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("comsumer")
public class OrderController {

//    public static final String PAYENT_URL = "http://localhost:8001";

    public static final String PAYENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalaner loadBalaner;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("payment/selectOne/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYENT_URL+"/payment/selectOne/"+id,CommonResult.class);
    }

    @GetMapping("payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalaner.instance(instances);
        URI uri = serviceInstance.getUri();
        System.out.println(uri+"/payment/lb");
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
//        return uri+"/payment/lb";
    }
}
