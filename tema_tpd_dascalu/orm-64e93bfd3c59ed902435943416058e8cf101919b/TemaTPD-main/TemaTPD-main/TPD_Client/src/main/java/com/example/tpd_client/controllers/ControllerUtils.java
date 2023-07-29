package com.example.tpd_client.controllers;

import com.example.tpd_client.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public final class ControllerUtils {
    public static final String loggedUser = "loggedUser";

    public static boolean checkLoggedInUser(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
        User loggedUser = (User) request.getSession().getAttribute(ControllerUtils.loggedUser);
        if (loggedUser == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.include(request, response);
        return true;
    }

    public static String stringOrEmpty(Object value) {
        return value == null ? "" : (String) value;
    }
}
