package org.acme.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.acme.Model.OpenWeatherResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.openweathermap.org")
public interface OpenWeatherService {

    @GET
    @Path("/data/2.5/weather")
    @Produces(MediaType.APPLICATION_JSON)
    public OpenWeatherResource getByName(@QueryParam("q") String city, @QueryParam("appid") String key);
}