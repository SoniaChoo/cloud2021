package com.sonia.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderFeignHystrixMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain9001.class, args);
    }
}
