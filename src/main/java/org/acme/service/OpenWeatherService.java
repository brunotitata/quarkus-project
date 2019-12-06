package org.acme.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.Model.OpenWeatherResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@RegisterRestClient(baseUri = "https://api.openweathermap.org/data")
public interface OpenWeatherService {

    // url
    // https://api.openweathermap.org/data/2.5/weather?q=Curitiba&appid=928ef3a318da4fe2ab4ba417b636e109

    @GET
    @Path("/2.5/weather?q={city}&appid=928ef3a318da4fe2ab4ba417b636e109")
    @Produces(MediaType.APPLICATION_JSON)
    public OpenWeatherResource getByName(@PathParam String city);
}