package org.acme.model;

import java.util.List;

import javax.json.bind.annotation.JsonbPropertyOrder;

import org.acme.service.Climate.Drink;
import org.acme.service.Climate.Entertainment;

@JsonbPropertyOrder({ "city", "temperature" })
public class Recommendation {
    private String city;
    private Integer temperature;
    private List<Drink> drink;
    private List<Entertainment> entertainment;

    public Recommendation(String city, Integer temperature, List<Drink> drink, List<Entertainment> entertainment) {
        this.city = city;
        this.temperature = temperature;
        this.drink = drink;
        this.entertainment = entertainment;
    }

    @SuppressWarnings("unused")
    private Recommendation() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
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
}