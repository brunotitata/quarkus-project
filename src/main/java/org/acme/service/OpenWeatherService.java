package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

import org.acme.http.OpenWeatherHttpClient;
import org.acme.model.OpenWeatherResource;
import org.acme.model.Recommendation;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class OpenWeatherService {

    @ConfigProperty(name = "token.appid")
    String token;

    @RestClient
    public OpenWeatherHttpClient openWeatherHttpClient;

    private OpenWeatherResource getCity(String lat, String lon) {
        return openWeatherHttpClient.getCityByLatAndLon(lat, lon, token);

    }

    public OpenWeatherResource getCityByName(String name) {
        OpenWeatherResource cidade = openWeatherHttpClient.getByName(name, token);

        if (cidade == null)
            return new OpenWeatherResource();
        return cidade;
    }

    public Recommendation suggestRecommendation(String lat, String lon) {

        Climate recommendation = Climate.getClimate(getCity(lat, lon).getMain().getTemp());

        return new Recommendation(captureCityName(lat, lon),
                Climate.convertKelvinToCelsius(captureTemperature(lat, lon)), recommendation.getDrink(),
                recommendation.getEntertainment());
    }

    private Double captureTemperature(String lat, String lon) {
        return getCity(lat, lon).getMain().getTemp();
    }

    private String captureCityName(String lat, String lon) {
        return getCity(lat, lon).getName();
    }

}