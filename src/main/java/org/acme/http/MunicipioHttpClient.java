package org.acme.http;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.acme.model.CidadeResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://servicodados.ibge.gov.br")
public interface MunicipioHttpClient {

    @GET
    @Path("/api/v1/localidades/municipios/")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CidadeResource> buscarTodosMunicipios();

}
