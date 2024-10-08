package com.controller.user;

import com.dao.impl.UserDaoImpl;
import com.model.User;
import com.service.impl.UserServiceImpl;
import com.service.interfaces.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * Default constructor.
     */
    public UserLoginServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        // Initialize the UserService with UserDao implementation
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    /**
     * Handles GET requests.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to login page
        response.sendRedirect("login.jsp");
    }

    /**
     * Handles POST requests (user login).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.login(username, password);
            if (user != null) {
                // User found, create a session
                System.out.println("login success");
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                // Redirect to dashboard after successful login
                response.sendRedirect(request.getContextPath() + "/register.jsp");
            } else {
                System.out.println("login failed");
                // Invalid login, forward to login page with error
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Handle unexpected exceptions
            System.out.println("login failed catch exception");
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
