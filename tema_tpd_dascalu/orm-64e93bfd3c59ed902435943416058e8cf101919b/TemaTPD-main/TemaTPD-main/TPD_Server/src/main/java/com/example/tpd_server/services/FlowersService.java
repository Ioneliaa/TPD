package com.example.tpd_server.services;

import com.example.tpd_server.data_access.FlowersDAO;
import com.example.tpd_server.models.Flowers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class FlowersService {
    public ArrayList<Flowers> getAll() {
        return FlowersDAO.getAll();
    }

    public Flowers get(int id) {
        if (id < 0) {
            return null;
        }
        return FlowersDAO.get(id);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            Flowers flowers = mapper.readValue(response, new TypeReference<>() {
            });
            FlowersDAO.add(flowers);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int flowersId) {
        if (flowersId < 0) {
            return;
        }

        try {
            FlowersDAO.delete(flowersId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
