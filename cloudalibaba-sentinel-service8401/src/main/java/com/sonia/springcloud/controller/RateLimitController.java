package com.sonia.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sonia.springcloud.entities.CommonResult;
import com.sonia.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {
    @GetMapping(value = "/byresource")
    @SentinelResource(value = "byResource", blockHandler = "deal_byresource")
    public CommonResult byresource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "sonia"));
    }
    public CommonResult deal_byresource(BlockException exception) {
        return new CommonResult(500,exception.getClass().getCanonicalName());
    }

    @GetMapping(value = "/byUrl")
    @SentinelResource(value = "/byUrl", blockHandler = "deal_byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200,"by url", new Payment(1998L,"tony"));
    }

    public CommonResult deal_byUrl(BlockException exception) {
        return new CommonResult(999,exception.getClass().getCanonicalName());
    }
}