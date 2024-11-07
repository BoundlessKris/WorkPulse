package com.controller.user;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class UserListServlet
 */

@WebServlet("/admin/userList")
public class UserListServlet extends HttpServlet {
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

		User currentUser = (User) session.getAttribute("user");
		if (!"admin".equals(currentUser.getUserType())) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
			return;
		}

		try {
			List<User> users = userService.getAllUsers();
			request.setAttribute("users", users);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/userList.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/admin/userList.jsp").forward(request, response);
		}
	}
}
