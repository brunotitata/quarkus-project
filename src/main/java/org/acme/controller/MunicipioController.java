package org.acme.controller;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.MunicipioEntity;
import org.acme.service.MunicipioService;

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

}