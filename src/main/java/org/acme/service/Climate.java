package org.acme.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Climate {
    COLD(Arrays.asList(new Drink("Coffee"), new Drink("Whisky")),
            Arrays.asList(new Entertainment("Cooking"), new Entertainment("Watch movies"))),

    MILD(Arrays.asList(new Drink("Water"), new Drink("Soda")), Arrays.asList(new Entertainment("Sightseeing"))),

    HOT(Arrays.asList(new Drink("Water"), new Drink("Beer"), new Drink("Soda"), new Drink("Milkshake")), Arrays
            .asList(new Entertainment("Sightseeing"), new Entertainment("Surfing"), new Entertainment("Wash a car ")));

    private List<Drink> drink;
    private List<Entertainment> entertainment;

    private Climate(List<Drink> drink, List<Entertainment> entertainment) {
        this.drink = drink;
        this.entertainment = entertainment;
    }

    public List<Drink> getDrink() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public List<Entertainment> getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(List<Entertainment> entertainment) {
        this.entertainment = entertainment;
    }

    public static Climate getClimate(Double temperature) {
        Integer temperatureCelsius = convertKelvinToCelsius(temperature);

        if (temperatureCelsius < 15) {
            return Climate.COLD;
        } else if (temperatureCelsius >= 15 && temperatureCelsius < 30) {
            return Climate.MILD;
        }
        return Climate.HOT;

    }

    public static Integer convertKelvinToCelsius(Double temperature) {
        return new BigDecimal(temperature - 273.15F).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

    }

    public static class Drink {
        private String recommendation;

        public Drink(String recommendation) {
            this.recommendation = recommendation;
        }

        public String getRecommendation() {
            return recommendation;
        }

        public void setRecommendation(String recommendation) {
            this.recommendation = recommendation;
        }

    }

    public static class Entertainment {
        private String recommendation;

        public Entertainment(String recommendation) {
            this.recommendation = recommendation;
        }

        public String getRecommendation() {
            return recommendation;
        }

        public void setRecommendation(String type) {
            this.recommendation = type;
        }

    }

}