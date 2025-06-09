package com.example.domain;

public interface OrderService {
    void processOrder(Order order);
    void sendProcessedOrder(String order);
}
