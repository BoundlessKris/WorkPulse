package com.controller.user;

import com.dao.impl.UserDaoImpl;
import com.service.impl.UserServiceImpl;
import com.service.interfaces.UserService;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPasswordResetServlet
 */

@WebServlet("/user/resetPassword")
public class UserPasswordResetServlet extends HttpServlet {
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/user/resetPassword.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");

		try {
			userService.resetPassword(email);
			request.setAttribute("message", "Password reset instructions have been sent to your email.");
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
		}

		request.getRequestDispatcher("/WEB-INF/jsp/user/resetPassword.jsp").forward(request, response);
	}
}
