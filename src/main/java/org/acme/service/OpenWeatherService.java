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

    public OpenWeatherResource getCity(String... args) {

	if (args.length <= 0)
	    throw new RuntimeException("É Obrigatorio passar um ou mais valores no parametro!");
	else if (args.length == 1) {
	    return openWeatherHttpClient.getByName(args[0], token);
	}

	return openWeatherHttpClient.getCityByLatAndLon(args[0], args[1], token);

    }

    public Recommendation suggestRecommendation(String... params) {

	Climate recommendation = Climate.getClimate(getCity(params).getMain().getTemp());

	return new Recommendation(captureCityName(params), Climate.convertKelvinToCelsius(captureTemperature(params)),
		recommendation.getDrink(), recommendation.getEntertainment());
    }

    private Double captureTemperature(String... params) {
	return getCity(params).getMain().getTemp();
    }

    private String captureCityName(String... params) {
	return getCity(params).getName();
    }

}