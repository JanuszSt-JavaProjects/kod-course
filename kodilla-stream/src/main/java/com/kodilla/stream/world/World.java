package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class World {

    private final Set<Continent> continentsSet = new HashSet<>();

    public World(final Continent... continents) {
        for (Continent continent : continents) {
            continentsSet.add(continent);
        }
    }

    BigDecimal getPeopleQuantity() {
        return continentsSet.stream()
                .flatMap(continent -> continent.getCountriesSet().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof World)) return false;
        World world = (World) o;
        return Objects.equals(continentsSet, world.continentsSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continentsSet);
    }
}
