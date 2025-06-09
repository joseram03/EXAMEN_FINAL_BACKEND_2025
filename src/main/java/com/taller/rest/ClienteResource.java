package com.taller.rest;

import com.taller.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @POST
    @Transactional
    public Response registrar(Cliente cliente) {
        try {
            em.persist(cliente);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error al registrar Cliente: " + e.getMessage()).build();
        }
    }
}
