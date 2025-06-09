package com.taller.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ping")
public class PingResource {

    @GET
    @Produces("text/plain")
    public String ping() {
        return "pong";
    }
}
