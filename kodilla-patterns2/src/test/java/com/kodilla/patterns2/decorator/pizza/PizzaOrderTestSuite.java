package com.kodilla.patterns2.decorator.pizza;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class PizzaOrderTestSuite {


    @Test
    void createStandardPizza() {
        Pizza pizzaStandard = new StandardPizza();

        assertEquals(new BigDecimal(35), pizzaStandard.getPrice());
        assertEquals("Standard Pizza", pizzaStandard.getIngredientsDescription());
    }

    @Test
    void createPizzaWithSeafood(){

        Pizza pizza= new StandardPizza();
        pizza = new SeafoodPizza(pizza);

        assertEquals(new BigDecimal(20 + 35),pizza.getPrice());
        assertEquals("Standard Pizza and seafood",pizza.getIngredientsDescription());
    }

    @Test
    void createPizzaWithSeafoodAndBacon(){

        Pizza pizza= new StandardPizza();
        pizza = new SeafoodPizza(pizza);
        pizza = new BaconPizza(pizza);

        assertEquals(new BigDecimal(20 + 35 + 12),pizza.getPrice());
        assertEquals("Standard Pizza and seafood and bacon",pizza.getIngredientsDescription());
    }
}
