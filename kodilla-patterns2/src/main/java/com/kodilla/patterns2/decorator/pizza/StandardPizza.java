package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class StandardPizza implements Pizza {

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(35);
    }

    @Override
    public String getIngredientsDescription() {
        return "Standard Pizza";
    }
}
