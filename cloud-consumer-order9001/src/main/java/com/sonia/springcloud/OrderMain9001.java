package com.sonia.springcloud;

import com.sonia.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "CLOUD_PAYMENT_SERVICE", configuration = MySelfRule.class)
public class OrderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain9001.class, args);
    }
}
