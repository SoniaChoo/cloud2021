package com.sonia.springcloud.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.entities.Payment;
import com.sonia.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***************payment={}", JSONUtils.toJSONString(payment));
        log.info("***************result={}", result);
        if (result > 0) {
            return new CommonResult(200, "insert success", result);
        } else {
            return new CommonResult(444, "insert fail");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("***************result={}", JSONUtils.toJSONString(result));
        log.info("***************id={}", id);
        if (result != null) {
            return new CommonResult(200,"query success", result);
        }else{
            return new CommonResult(444,"query fail:id="+id);
        }
    }
}
