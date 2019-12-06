package org.acme.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.acme.Model.OpenWeatherResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.openweathermap.org")
public interface OpenWeatherHttpClient {

    @GET
    @Path("/data/2.5/weather")
    public OpenWeatherResource getByName(@QueryParam("q") String city, @QueryParam("appid") String key);

    @GET
    @Path("/data/2.5/weather")
    public OpenWeatherResource getCityByLatAndLon(@QueryParam("lat") String lat, @QueryParam("lon") String lon,
            @QueryParam("appid") String appid);
}