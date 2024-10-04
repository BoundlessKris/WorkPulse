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
		userService = new UserServiceImpl(new UserDaoImpl());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String userType = request.getParameter("userType");

		if (!password.equals(confirmPassword)) {
			request.setAttribute("error", "Passwords do not match");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if (userType == null || (!userType.equals("buyer") && !userType.equals("seller"))) {
			request.setAttribute("error", "Invalid user type selected");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPasswordHash(password);  // Will be hashed in UserService
		user.setUserType(userType);

		try {
			User registeredUser = userService.registerUser(user);
			if (registeredUser != null) {
				request.setAttribute("message", "Registration successful! Please log in.");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				request.setAttribute("error", "Registration failed. Please try again.");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
	}


