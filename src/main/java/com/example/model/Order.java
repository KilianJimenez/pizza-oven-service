package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private List<Pizza> pizzas;

    public double getTotalPrice() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
    }

    public String toString() {
        String pizzaNames = String.valueOf(pizzas.stream()
                                  .map(Pizza::getName)
                                  .reduce((name1, name2) -> Name.valueOf(name1 + ", " + name2))
        );

        return "Order{" +
                "pizzas=" + pizzaNames +
                '}';
    }
}
