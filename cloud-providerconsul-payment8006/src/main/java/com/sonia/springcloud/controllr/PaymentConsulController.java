package com.sonia.springcloud.controllr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentconsul() {
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

    @GetMapping("/actuator/health")
    public String healthInfo() {
        return "cloud-provider-paymentconsul-8006 SUCCESS";
    }
}
