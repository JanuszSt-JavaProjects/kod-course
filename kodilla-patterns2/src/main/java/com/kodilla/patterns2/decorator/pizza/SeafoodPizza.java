package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SeafoodPizza extends AbstractPizzaDecorator {


    public SeafoodPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(20));
    }

    @Override
    public String getIngredientsDescription() {
        return super.getIngredientsDescription().concat(" and seafood");
    }
}
