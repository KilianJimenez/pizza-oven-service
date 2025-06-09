package com.example.infrastructure;

import com.example.domain.Order;
import com.example.domain.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class OrderListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(OrderListener.class);
    private final OrderService orderService;

    public OrderListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @RabbitListener(queues = "order-queue")
    public void onMessage(Message message) {
        log.info("Received order: {}", message.toString());
        Order order = mapToStringObject(message);
        orderService.processOrder(order);
    }

    private Order mapToStringObject(Message message) {
        Order result = null;
        try {
            String json = new String(message.getBody(), StandardCharsets.UTF_8);
            result = new ObjectMapper().readValue(json, Order.class);
        } catch (Exception e) {
            log.error("Error parsing JSON message: {}", e.getMessage());
        }
        return result;
    }
}
