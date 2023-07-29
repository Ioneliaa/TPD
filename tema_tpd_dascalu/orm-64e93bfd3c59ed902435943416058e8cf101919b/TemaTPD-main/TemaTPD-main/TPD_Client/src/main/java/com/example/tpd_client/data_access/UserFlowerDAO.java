package com.example.tpd_client.data_access;

import com.example.tpd_client.models.Flower;
import com.example.tpd_client.models.UserFlower;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class UserFlowerDAO {
    private final static HttpClient client = HttpClient.newHttpClient();

    public static ArrayList<UserFlower> getAllUserFlowers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/TPD_Server-1.0-SNAPSHOT/api/user-flowers"))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.body().isEmpty()) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<ArrayList<UserFlower>>() {
        });
    }

    public static List<Flower> getFlowersForUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/TPD_Server-1.0-SNAPSHOT/api/user-flowers/" + userId))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.body().isEmpty()) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<Flower>>() {
        });
    }



    public static void add(UserFlower userFlower) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userFlower);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/TPD_Server-1.0-SNAPSHOT/api/user-flowers"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Accept", "application/json")
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static void delete(int userId, int flowerId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/TPD_Server-1.0-SNAPSHOT/api/user-flowers/" +
                        userId + "/" + flowerId))
                .DELETE()
                .header("Accept", "application/json")
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
