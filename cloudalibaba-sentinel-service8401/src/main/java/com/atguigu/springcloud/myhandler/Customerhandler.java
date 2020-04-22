package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;


public class Customerhandler {

    public CommonResult handlerException(BlockException exception) {
        return new CommonResult(444,"按客户自定义，global handlerException",new Payment(2020L,"serial003"));
    }

    public CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"按客户自定义，global handlerException2",new Payment(2020L,"serial003"));
    }
}
