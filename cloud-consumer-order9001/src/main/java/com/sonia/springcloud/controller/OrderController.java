package com.sonia.springcloud.controller;

import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.entities.Payment;
import com.sonia.springcloud.loadBalance.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if ( entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else {
            return new CommonResult<Payment>(entity.getStatusCode().value(),"query failed");
        }
    }

    @GetMapping("/consumer/payment/getLB/{id}")
    public CommonResult<Payment> getPaymentLB(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance currentInstance = loadBalance.getInstances(instances);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(currentInstance.getUri() + "/payment/get/" + id, CommonResult.class);
        if ( entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else {
            return new CommonResult<Payment>(entity.getStatusCode().value(),"query failed");
        }
    }

    @GetMapping(value = "/orderZipkin")
    public String orderZipkin() {
        return restTemplate.getForObject(PAYMENT_URL+"/paymentZipkin",String.class);
    }
}
