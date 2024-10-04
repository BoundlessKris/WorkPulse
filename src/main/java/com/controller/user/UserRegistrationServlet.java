package com.controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.interfaces.UserService;
import com.service.impl.UserServiceImpl;
import com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		// Initializing the UserService with UserDaoImpl
		userService = new UserServiceImpl(new UserDaoImpl());
	}

	/**
	 * Handles GET requests for the registration page
	 */

	/**
	 * Handles POST requests for user registration
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form data
		String username = request.getParameter("username").trim();
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		String confirmPassword = request.getParameter("confirmPassword").trim();
		String userType = request.getParameter("userType");

		// Input validation
		if (!password.equals(confirmPassword)) {
			request.setAttribute("error", "Passwords do not match.");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		if (userType == null || (!userType.equals("buyer") && !userType.equals("seller"))) {
			request.setAttribute("error", "Invalid user type selected.");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		// Prepare user object
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPasswordHash(password);  // Password will be hashed in the UserService
		user.setUserType(userType);

		try {
			// Register the user
			User registeredUser = userService.registerUser(user);
			if (registeredUser != null) {
				// Registration success
				request.setAttribute("message", "Registration successful! Please log in.");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				// Registration failed
				request.setAttribute("error", "Registration failed. Please try again.");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// Catch and display any exception that occurs
			e.printStackTrace(); // For debugging purposes
			request.setAttribute("error", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
}
