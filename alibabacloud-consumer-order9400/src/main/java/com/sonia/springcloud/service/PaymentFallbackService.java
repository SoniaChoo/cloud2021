package com.sonia.springcloud.service;

import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
