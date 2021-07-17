package com.sonia.springcloud.controller;

import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/payment/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id) {
        return paymentFeignService.paymentSQL(id);
    }
}
