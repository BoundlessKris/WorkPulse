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

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public UserRegistrationServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        // Initialize UserService with UserDao implementation
        userService = new UserServiceImpl(new UserDaoImpl());
    }

    /**
     * Handles GET requests.
     */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// Redirect to the registration page
//		response.sendRedirect("login.jsp");
//	}

    /**
     * Handles POST requests (user registration).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String userType = request.getParameter("userType");

        // Validate password confirmation
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match");
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        // Create a new User object and set its properties
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(password); // Ensure the password is hashed inside UserService
        user.setUserType(userType);
        user.setSellerLevel("new"); // Default value if not provided
        user.setCreatedAt(LocalDateTime.now()); // Set the creation time

        try {
            // Log for debugging
            System.out.println("Attempting to register user: " + username);

            User registeredUser = userService.registerUser(user);
            if (registeredUser != null) {
                // Registration successful, redirect to login page
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                System.out.println("registration successful");
            } else {
                // Registration failed, display error on registration page
                System.out.println("registration unsuccessful");
                request.setAttribute("error", "Registration failed. Please try again.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any unexpected exceptions
            System.out.println("registration unsuccessful catch block");
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
