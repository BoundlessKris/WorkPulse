package com.controller.user;

import com.model.User;
import com.service.interfaces.UserService;
import com.service.impl.UserServiceImpl;
import com.dao.impl.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/user/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		User user = (User) session.getAttribute("user");
		user.setEmail(request.getParameter("email"));
		// Set other updatable fields

		try {
			User updatedUser = userService.updateUser(user);
			session.setAttribute("user", updatedUser);
			request.setAttribute("message", "Profile updated successfully");
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
		}

		request.getRequestDispatcher("/WEB-INF/jsp/user/profile.jsp").forward(request, response);
	}
}
