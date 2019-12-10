package org.acme.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.http.MunicipioHttpClient;
import org.acme.service.OpenWeatherService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/api")
public class OpenWeatherController {

    OpenWeatherService openWeatherService;

    @RestClient
    MunicipioHttpClient municipioHttpClient;

    public OpenWeatherController(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GET
    @Path("/coordenadas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lat(@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude) {
        return Response.ok(openWeatherService.suggestRecommendation(latitude, longitude)).build();
    }
}