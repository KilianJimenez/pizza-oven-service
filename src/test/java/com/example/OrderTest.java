package com.example;

import com.example.model.Order;
import com.example.model.pizza.Name;
import com.example.model.pizza.Pizza;
import com.example.model.pizza.Size;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PizzaTest {

    @Test
    public void testOrderToString() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza(Name.DIAVOLA, Size.M));
        pizzas.add(new Pizza(Name.FRUTTI_DI_MARE, Size.L));
        Order order = new Order(pizzas);

        assertEquals(order.toString(), "Order{pizzas=DIAVOLA, FRUTTI_DI_MARE}");
    }
}
