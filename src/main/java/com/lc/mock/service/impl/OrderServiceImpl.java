package com.lc.mock.service.impl;

import com.lc.mock.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void printOrder() {
        System.out.println("打印订单...");
    }
}
