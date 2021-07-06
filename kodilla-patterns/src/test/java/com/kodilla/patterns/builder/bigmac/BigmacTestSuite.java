package com.kodilla.patterns.builder.bigmac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BigmacTestSuite {

    @Test
    void createBurger() {
        //Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder();

        //When
        Bigmac bigMac = builder
                .bun(Bigmac.Bun.SESAME)
                .burgers(2)
                .ingredient(Bigmac.Ingredient.CUCUMBER)
                .ingredient(Bigmac.Ingredient.BACON)
                .ingredient(Bigmac.Ingredient.CHEESE)
                .sauce(Bigmac.Sauce.ONE_THOUSAND_ISLANDS)
                .bigMacBuilder();

        //Then
        assertTrue(bigMac.getIngredients().size() == 3);
        assertEquals(2, bigMac.getBurgers());
        assertSame(Bigmac.Bun.SESAME, bigMac.getBun());
        assertSame(Bigmac.Sauce.ONE_THOUSAND_ISLANDS, bigMac.getSauce());

    }


}
