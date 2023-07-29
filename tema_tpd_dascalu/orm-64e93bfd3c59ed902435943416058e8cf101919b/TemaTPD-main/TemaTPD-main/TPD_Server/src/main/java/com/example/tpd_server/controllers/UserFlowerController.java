package com.example.tpd_server.controllers;

import com.example.tpd_server.models.Flowers;
import com.example.tpd_server.models.UserFlowers;
import com.example.tpd_server.services.UserFlowersService;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/user-flowers")
public class UserFlowerController {
    private static final UserFlowersService user_flowers_service = new UserFlowersService();

    @GET
    @Produces("application/json")
    public List<UserFlowers> getAll() {
        return user_flowers_service.getAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{userId}")
    public List<Flowers> getFlowersForUser(@PathParam("userId") int userId) {
        return user_flowers_service.getFlowersForUser(userId);
    }

    @POST
    @Consumes("application/json")
    public void add(String response) {
        user_flowers_service.add(response);
    }

    @DELETE
    @Consumes("application/json")
    @Path("/{userId}/{flowersId}")
    public void delete(@PathParam("userId") int userId, @PathParam("flowersId") int flowersId){
        user_flowers_service.delete(userId, flowersId);
    }
}
