package com.sonia.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping(value = "/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

    @GetMapping(value = "/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        int age = 10/0;
        return "------testE";
    }

    @GetMapping(value = "/testF")
    public String testF() {
        int age = 10/0;
        return "------testF";
    }

    @GetMapping(value = "/testG/{id}")
    public String testG(@PathVariable("id") Long id) {
        if (id == 1) {
            int age = 10 / 0;
        }
        return "------testG";
    }


    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey", blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1",required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        int age = 10 / 0;
        return "--testHostKey";
    }

    public String deal_testHostKey(String p1, String p2, BlockException exception) {
        return "---deal_testHostKey";
    }
}
