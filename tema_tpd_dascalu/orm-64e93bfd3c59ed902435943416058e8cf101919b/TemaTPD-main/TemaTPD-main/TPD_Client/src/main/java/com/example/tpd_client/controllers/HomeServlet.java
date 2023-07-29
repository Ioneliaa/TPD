package com.example.tpd_client.controllers;

import com.example.tpd_client.data_access.UserFlowerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HOME SERVLET - GET METHOD");
        String btnValue = req.getParameter("delete");
        if (btnValue != null) {
            doDelete(req, resp);
        }
        String username = req.getSession().getAttribute("username").toString();

        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
        int flowerId = Integer.parseInt(req.getParameter("delete"));
        try {
            UserFlowerDAO.delete(userId, flowerId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("button");
        if (button.equals("logout")) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else if (button.equals("manage-flowers")) {
            resp.sendRedirect(req.getContextPath() + "/manage-flowers");
        }
    }
}
