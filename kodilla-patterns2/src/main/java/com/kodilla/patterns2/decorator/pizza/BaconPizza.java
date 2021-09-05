package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BaconPizza extends AbstractPizzaDecorator{

    protected BaconPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(12));
    }

    @Override
    public String getIngredientsDescription() {
        return super.getIngredientsDescription().concat(" and bacon");
    }

}
