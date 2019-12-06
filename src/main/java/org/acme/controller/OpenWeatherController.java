package org.acme.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.Model.Recommendation;
import org.acme.service.OpenWeatherService;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/api")
public class OpenWeatherController {

    OpenWeatherService openWeatherService;

    public OpenWeatherController(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public OpenWeatherResource name(@QueryParam("city") String city) {
    // return openWeatherService.getByName(city, appid);
    // }

    @GET
    @Path("/coordenadas")
    @Produces(MediaType.APPLICATION_JSON)
    public Recommendation lat(@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude) {
        return openWeatherService.suggestRecommendation(latitude, longitude);
    }

}