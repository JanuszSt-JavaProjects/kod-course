package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private List<Ingredient> ingredients;


    protected enum Bun {STANDARD, SESAME}
    protected enum Sauce {STANDARD, ONE_THOUSAND_ISLANDS, BARBECUE}
    protected enum Ingredient {LETTUCE, ONION, BACON, CUCUMBER, CHILI_PEPPERS, MUSHROOMS, PRAWNS, CHEESE}


    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {

        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }


    public static class BigmacBuilder {

        private Bigmac.Bun bun;
        private int burgers;
        private Bigmac.Sauce sauce;
        private final List<Bigmac.Ingredient> ingredients = new ArrayList<>();


        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
