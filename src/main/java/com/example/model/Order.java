package com.example.model;

import com.example.model.pizza.Pizza;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @JsonProperty("pizzas")
    private List<Pizza> pizzas;

    public double getTotalPrice() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
    }

    public String toString() {
        String pizzaNames = pizzas.stream()
                                          .map(pizza -> pizza.getName().toString())
                                          .collect(Collectors.joining(", "));

        return "Order{pizzas=" + pizzaNames +"}";
    }
}
