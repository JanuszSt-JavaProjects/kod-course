package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country china = new Country(new BigDecimal("11111"));
        Country mongolia = new Country(new BigDecimal("22222"));
        Country japan = new Country(new BigDecimal("33333"));
        Continent asiaContinent = new Continent(china, mongolia, japan);

        Country hungary = new Country(new BigDecimal("44444"));
        Country spain = new Country(new BigDecimal("55555"));
        Continent europeContinent = new Continent(hungary, spain);

        Country australia = new Country(new BigDecimal("66666"));
        Continent australiaContinent = new Continent(australia);

        World world = new World(asiaContinent, europeContinent, australiaContinent);
        BigDecimal expectedWorldQuantity = new BigDecimal("11111")
                .add(new BigDecimal("22222")
                        .add(new BigDecimal("33333")
                                .add(new BigDecimal("44444")
                                        .add(new BigDecimal("55555")
                                                .add(new BigDecimal("66666"))))));

        //When
        BigDecimal actualWorldQuantity = world.getPeopleQuantity();

        //Then
        Assertions.assertEquals(expectedWorldQuantity, actualWorldQuantity);
    }
}
