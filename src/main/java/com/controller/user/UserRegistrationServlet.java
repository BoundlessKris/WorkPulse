package com.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.interfaces.UserService;
import com.service.impl.UserServiceImpl;
import com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/user/register")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!password.equals(confirmPassword)) {
			request.setAttribute("error", "Passwords do not match");
			request.getRequestDispatcher("/WEB-INF/jsp/user/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPasswordHash(password);  // Will be hashed in UserService

		try {
			User registeredUser = userService.registerUser(user);
			if (registeredUser != null) {
				request.setAttribute("message", "Registration successful! Please log in.");
				response.sendRedirect(request.getContextPath() + "/user/login");
			} else {
				request.setAttribute("error", "Registration failed. Please try again.");
				request.getRequestDispatcher("/WEB-INF/jsp/user/register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/user/register.jsp").forward(request, response);
		}
	}
	}


