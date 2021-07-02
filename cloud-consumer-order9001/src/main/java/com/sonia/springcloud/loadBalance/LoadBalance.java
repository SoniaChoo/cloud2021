package com.sonia.springcloud.loadBalance;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    public ServiceInstance getInstances(List<ServiceInstance> serviceInstanceList);
}
