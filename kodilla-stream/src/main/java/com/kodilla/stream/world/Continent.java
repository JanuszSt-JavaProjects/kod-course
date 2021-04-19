package com.kodilla.stream.world;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Continent {

    private final Set<Country> countriesSet = new HashSet<>();


    public Continent(final Country... countries) {
        countriesSet.addAll(Arrays.asList(countries));
    }

    public Set<Country> getCountriesSet() {
        return countriesSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;
        Continent continent = (Continent) o;
        return Objects.equals(countriesSet, continent.countriesSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countriesSet);
    }
}


