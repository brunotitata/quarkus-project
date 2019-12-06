package org.acme.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.Model.OpenWeatherResource;
import org.acme.service.OpenWeatherService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/api")
public class OpenWeatherController {

    @Inject
    @RestClient
    OpenWeatherService openWeatherService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OpenWeatherResource name(@QueryParam("city") String city) {

        return openWeatherService.getByName(city);
    }

}