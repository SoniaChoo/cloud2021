package com.sonia.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String INVOKE_URL;

    @GetMapping(value = "/consumer/payment/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")
//    @SentinelResource(value = "fallback", blockHandler = "handlerBlock")
    @SentinelResource(value = "fallback",blockHandler = "handlerBlock", fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(INVOKE_URL + "/payment/"+id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    public CommonResult handlerBlock(@PathVariable("id") Long id, BlockException e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(888,"blockHandler",payment);
    }

    public CommonResult handlerFallback(@PathVariable("id") Long id,Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(666,"handlerFallback"+e.getMessage(),payment);
    }
}
