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
 * Servlet implementation class UserSearchServlet
 */

@WebServlet("/user/search")
public class UserSearchServlet extends HttpServlet {
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

		String keyword = request.getParameter("keyword");
		if (keyword != null && !keyword.trim().isEmpty()) {
			try {
				List<User> searchResults = userService.searchUsers(keyword);
				request.setAttribute("searchResults", searchResults);
			} catch (Exception e) {
				request.setAttribute("error", "An error occurred during the search: " + e.getMessage());
			}
		}

		request.getRequestDispatcher("/WEB-INF/jsp/user/search.jsp").forward(request, response);
	}
}
