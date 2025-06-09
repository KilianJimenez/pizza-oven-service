package com.example.service;

import com.example.model.Order;

public interface OrderService {
    void processOrder(Order order);
    void sendProcessedOrder(String order);
}
