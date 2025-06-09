package com.taller.rest;

import com.taller.model.Repuesto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("repuestos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RepuestoResource {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @POST
    @Transactional
    public Response registrar(Repuesto repuesto) {
        try {
            em.persist(repuesto);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error al registrar Repuesto: " + e.getMessage()).build();
        }
    }
}
