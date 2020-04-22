package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalaner {

    ServiceInstance instance(List<ServiceInstance> instances);
}
