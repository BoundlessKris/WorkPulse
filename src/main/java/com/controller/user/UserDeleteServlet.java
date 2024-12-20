package com.controller.user;

import com.dao.impl.UserDaoImpl;
import com.model.User;
import com.service.impl.UserServiceImpl;
import com.service.interfaces.UserService;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDeleteServlet
 */

@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
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

		request.getRequestDispatcher("/WEB-INF/jsp/user/deleteConfirmation.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		User user = (User) session.getAttribute("user");
		String confirmDelete = request.getParameter("confirmDelete");

		if ("yes".equalsIgnoreCase(confirmDelete)) {
			try {
				userService.deleteUser(user.getUserId());
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/user/login?message=Account deleted successfully");
			} catch (Exception e) {
				request.setAttribute("error", "An error occurred while deleting the account: " + e.getMessage());
				request.getRequestDispatcher("/WEB-INF/jsp/user/deleteConfirmation.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/user/profile");
		}
	}
}
