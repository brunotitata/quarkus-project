package org.acme.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.Model.OpenWeatherResource;
import org.acme.service.OpenWeatherHttpClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/api")
public class OpenWeatherController {

    @ConfigProperty(name = "token.appid")
    String appid;

    @RestClient
    OpenWeatherHttpClient openWeatherService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OpenWeatherResource name(@QueryParam("city") String city) {
        return openWeatherService.getByName(city, appid);
    }

    @GET
    @Path("/coordenadas")
    @Produces(MediaType.APPLICATION_JSON)
    public OpenWeatherResource lat(@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude) {
        return openWeatherService.getCityByLatAndLon(latitude, longitude, appid);
    }

}