package org.acme.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.model.MunicipioEntity;
import org.acme.model.MunicipioEntity.MunicipioData;
import org.acme.service.MunicipioService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.specimpl.ResponseBuilderImpl;

@Path("/api")
public class MunicipioController {

    MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
	this.municipioService = municipioService;
    }

    @GET
    @Path("/municipios")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response salvarMunicipios() {
	municipioService.salvarMunicipios();
	return Response.ok().build();
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response listarTodosMunicipios() {
	return Response.ok(municipioService.listarTodosMunicipiosSalvo()).build();
    }

    @GET
    @Path("/municipios/SP/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosMunicipiosDoEstadoSP() {
	municipioService.salvarMunicipioDoEstadoDeSP();
	return Response.ok(MunicipioEntity.findAll().list()).build();
    }

    @POST
    @Path("/municipio/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarMunicipio(@Valid MunicipioData municipioData) {
	MunicipioEntity novoMunicipio = municipioService.cadastrarMunicipio(municipioData);
	try {
	    return Response.created(new URI("/api/municipio/" + novoMunicipio.getUuid())).entity(novoMunicipio).build();
	} catch (URISyntaxException e) {
	    return new ResponseBuilderImpl().status(Status.BAD_REQUEST).build();
	}
    }

    @GET
    @Path("/municipio/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarMunicipioPorUUID(@PathParam String uuid) {
	return Response.ok(municipioService.buscarMunicipioPorUUID(UUID.fromString(uuid))).build();
    }

    @DELETE
    @Path("/municipio/{uuid}")
    public Response deletarMunicipio(@PathParam String uuid) {
	municipioService.deletarMunicipioPorUUID(UUID.fromString(uuid));
	return Response.noContent().build();
    }

}