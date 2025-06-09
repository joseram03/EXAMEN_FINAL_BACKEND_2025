package com.taller.rest;

import com.taller.model.Vehiculo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoResource {

    @PersistenceContext(unitName = "ecommercePU")
    private EntityManager em;

    @POST
    @Transactional
    public Response registrar(Vehiculo vehiculo) {
        try {
            em.persist(vehiculo);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error al registrar Vehiculo: " + e.getMessage()).build();
        }
    }
}
