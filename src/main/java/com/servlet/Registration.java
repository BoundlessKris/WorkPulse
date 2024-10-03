package com.servlet;

import com.dao.RegistrationDao;
import com.model.RegModel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Registration() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        RegModel regModel = new RegModel(name, email, username,password);
        RegistrationDao dao = new RegistrationDao();
        boolean isSaved = dao.saveRegistration(regModel);

        if (isSaved) {
            response.getWriter().append("Registration Successful!");
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().append("Registration Failed!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
