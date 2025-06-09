package com.example.domain;

import lombok.Data;

@Data
public class Pizza {
    private Name name;
    private double price;
    private Size size;

    public Pizza(Name name, Size size) {
        this.name = name;
        this.size = size;
        this.price = name.getBasePrice() + size.getExtraPrice();
    }

    public double getPrice() {
        return name.getBasePrice() + size.getExtraPrice();
    }
}
