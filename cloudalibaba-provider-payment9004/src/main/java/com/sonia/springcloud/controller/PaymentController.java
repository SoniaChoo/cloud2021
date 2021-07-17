package com.sonia.springcloud.controller;

import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"sonia"));
        hashMap.put(2L,new Payment(2L,"tony"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult paymentSQL(@PathVariable("id")Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult(200,"serverPort="+serverPort,payment);
    }
}
