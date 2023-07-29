package com.example.tpd_server.services;

import com.example.tpd_server.data_access.UserDAO;
import com.example.tpd_server.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class UserService {
    public ArrayList<User> getAll() {
        return UserDAO.getAll();
    }

    public User get(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return null;
        }
        return UserDAO.get(username, password);
    }

    public void add(String response) {
        if (response.isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue(response, new TypeReference<>() {
            });
            UserDAO.add(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
