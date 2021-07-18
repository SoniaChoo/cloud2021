package com.sonia.springcloud.service;

import com.sonia.springcloud.domain.Order;

public interface OrderService {
    void create(Order order);

    void update(Long userId, Integer status);
}
