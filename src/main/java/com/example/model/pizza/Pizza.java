package com.example.model.pizza;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    @JsonProperty("name")
    private Name name;
    private double price;
    @JsonProperty("size")
    private Size size;

    @JsonCreator
    public Pizza(@JsonProperty("name") Name name,@JsonProperty("size") Size size) {
        this.name = name;
        this.size = size;
        this.price = name.getBasePrice() + size.getExtraPrice();
    }

    public double getPrice() {
        return name.getBasePrice() + size.getExtraPrice();
    }
}
