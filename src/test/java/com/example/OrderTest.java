package com.example;

import com.example.model.Order;
import com.example.model.pizza.Name;
import com.example.model.pizza.Pizza;
import com.example.model.pizza.Size;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    @Test
    public void testOrderToString() {
        String expected = "Order{pizzas=DIAVOLA, FRUTTI_DI_MARE}";
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(Name.DIAVOLA, Size.M));
        pizzas.add(new Pizza(Name.FRUTTI_DI_MARE, Size.L));
        Order order = new Order(pizzas);

        assertEquals(expected, order.toString());
    }

    @Test
    public void testOrderTotalPrice() {
        Double expectedPrice = 15.0;

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(Name.DIAVOLA, Size.M));
        pizzas.add(new Pizza(Name.FRUTTI_DI_MARE, Size.L));
        Order order = new Order(pizzas);

        assertEquals(expectedPrice, order.getTotalPrice(), 0.0);
    }
}
