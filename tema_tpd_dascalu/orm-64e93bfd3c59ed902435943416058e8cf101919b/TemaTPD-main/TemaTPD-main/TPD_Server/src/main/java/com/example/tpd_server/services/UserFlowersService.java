package com.example.tpd_server.services;

import com.example.tpd_server.data_access.UserFlowersDAO;
import com.example.tpd_server.models.Flowers;
import com.example.tpd_server.models.UserFlowers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class UserFlowersService {
    public ArrayList<UserFlowers> getAll() {
        return UserFlowersDAO.getAll();
    }

    public List<Flowers> getFlowersForUser(int userId) {
        if(userId < 0){
            return null;
        }
        return UserFlowersDAO.getFlowersForUser(userId);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            UserFlowers userMotorcycle = mapper.readValue(response, new TypeReference<>() {
            });
            UserFlowersDAO.add(userMotorcycle);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int userId, int flowersId) {
        if (userId < 0 || flowersId < 0) {
            return;
        }

        try {
            UserFlowersDAO.delete(userId, flowersId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
