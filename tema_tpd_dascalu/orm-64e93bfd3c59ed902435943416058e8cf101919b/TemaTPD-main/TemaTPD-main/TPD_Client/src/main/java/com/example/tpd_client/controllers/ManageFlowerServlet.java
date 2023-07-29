package com.example.tpd_client.controllers;

import com.example.tpd_client.data_access.FlowerDAO;
import com.example.tpd_client.data_access.UserFlowerDAO;
import com.example.tpd_client.models.Flower;
import com.example.tpd_client.models.UserFlower;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "manageFlowersServlet", value = "/manage-flowers")
public class ManageFlowerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/manage-flowers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String button = request.getParameter("button");
        if (button == null) {
            return;
        }
        if(button.equals("home")){
            response.sendRedirect(request.getContextPath() + "/home");
        }

        if (button.equals("add-flowers")) {
            String result;
            try {
                result = TryToAddFlower(request);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(result != null) {
                System.err.println(result);
            }

            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    private String TryToAddFlower(HttpServletRequest request) throws IOException, InterruptedException {
        String color = request.getParameter("color");
        String name= String.valueOf(request.getParameter("name"));
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());

        if (color.isEmpty() || name.isEmpty()) {
            return "All fields must be filled";
        }

        List<Flower> ownedFlowers = UserFlowerDAO.getFlowersForUser(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
        if (containsFlower(ownedFlowers, color, name).isPresent()) {
            return "The user already owns the specified flower.";
        }

        List<Flower> allFlowers = FlowerDAO.getAllFlowers();

        Optional<Flower> flower = containsFlower(allFlowers, color, name);

        int flowerId;
        if (!flower.isPresent()) {
            Flower newFlower = new Flower(allFlowers.size() + 1, color, name);
            FlowerDAO.add(newFlower);
            flowerId = allFlowers.size() + 1;
        }
        else {
            flowerId = flower.get().getId();
        }
        UserFlower newUserFlowers = new UserFlower(userId, flowerId);
        UserFlowerDAO.add(newUserFlowers);

        return null;
    }

    private Optional<Flower> containsFlower(List<Flower> flowers, String color, String name) {
        Predicate<Flower> colorPredicate = flower -> flower.getColor().equals(color);
        Predicate<Flower> namePredicate = flower -> flower.getName() == name;
        Predicate<Flower> combinedPredicates = colorPredicate.and(namePredicate);
        return flowers.stream().filter(combinedPredicates).collect(Collectors.toList()).stream().findFirst();
    }
}
