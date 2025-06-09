package com.taller.rest;

import com.taller.model.Servicio;
import com.taller.services.ConsultaService;
import com.taller.services.ServicioService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/servicios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioResource {

    @EJB
    private ServicioService servicioService;

    @EJB
    private ConsultaService consultaService;

    // POST /api/servicios
    @POST
    public Response registrarServicio(Servicio servicio) {
        try {
            servicioService.registrarServicio(servicio);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error al registrar servicio: " + e.getMessage()).build();
        }
    }

    // GET /api/servicios?clienteId=1&fecha=2025-06-01
    @GET
    public Response consultarServicios(@QueryParam("clienteId") Long clienteId,
                                       @QueryParam("fecha") String fechaStr) {
        try {
            LocalDate fecha = (fechaStr != null && !fechaStr.isEmpty()) ? LocalDate.parse(fechaStr) : null;
            List<Servicio> servicios = consultaService.consultarServicios(clienteId, fecha);
            return Response.ok(servicios).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error al consultar servicios: " + e.getMessage()).build();
        }
    }
}
