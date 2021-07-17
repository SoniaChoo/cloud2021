package com.sonia.springcloud.service;

import com.sonia.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id);
}
