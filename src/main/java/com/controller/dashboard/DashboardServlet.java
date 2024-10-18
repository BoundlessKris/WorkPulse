package com.controller.dashboard;

import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        String userType = user.getUserType();

        switch (userType) {
            case "buyer":
                response.sendRedirect(request.getContextPath() + "/dashboard/buyer");
                break;
            case "seller":
                response.sendRedirect(request.getContextPath() + "/dashboard/seller");
                break;
            case "admin":
                response.sendRedirect(request.getContextPath() + "/dashboard/admin");
                break;
            default:
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid user type");
        }
    }
}
