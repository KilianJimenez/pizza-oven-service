package com.example.application;

import com.example.domain.Order;
import com.example.domain.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final RabbitTemplate rabbitTemplate;

    public OrderServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void processOrder(Order order) {
        String processedOrder = "";
        try {
            int delay = ThreadLocalRandom.current().nextInt(5000, 12000);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        processedOrder = "Your pizzas are on the way! Total price is " + order.getTotalPrice() + " € : " + order;

        sendProcessedOrder(processedOrder);
    }

    public void sendProcessedOrder(String processedOrder) {
        rabbitTemplate.convertAndSend("order-completed-exchange","routing-completed-key", processedOrder);
        log.info("Order processed and sent to the oven: {}", processedOrder);
    }
}
