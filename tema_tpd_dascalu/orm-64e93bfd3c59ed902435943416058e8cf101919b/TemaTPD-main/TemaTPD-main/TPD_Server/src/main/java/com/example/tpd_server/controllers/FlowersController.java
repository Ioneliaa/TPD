package com.example.tpd_server.controllers;

import com.example.tpd_server.models.Flowers;
import com.example.tpd_server.services.FlowersService;
import jakarta.ws.rs.*;

import java.util.ArrayList;

@Path("/flowers")
public class FlowersController {
    private static final FlowersService flowers_service = new FlowersService();

    @GET
    @Produces("application/json")
    public ArrayList<Flowers> getAll() {
        return flowers_service.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Flowers get(@PathParam("id") int id) {
        return flowers_service.get(id);
    }

    @POST
    @Consumes("application/json")
    public void add(String response) {
        flowers_service.add(response);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{flowerId}")
    public void delete(@PathParam("flowerId") int flowerId){
        flowers_service.delete(flowerId);
    }
}
