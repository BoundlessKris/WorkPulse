package com.controller.user;

import com.dao.impl.UserDaoImpl;
import com.model.User;
import com.service.impl.UserServiceImpl;
import com.service.interfaces.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserPasswordChangeServlet
 */
@WebServlet("/user/changePassword")
public class UserPasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPasswordChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return;
		}

		User user = (User) session.getAttribute("user");
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!newPassword.equals(confirmPassword)) {
			request.setAttribute("error", "New passwords do not match");
			request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
			return;
		}

		try {
			userService.changePassword(user.getUserId(), currentPassword, newPassword);
			request.setAttribute("message", "Password changed successfully");
			request.getRequestDispatcher("/WEB-INF/jsp/user/profile.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/user/changePassword.jsp").forward(request, response);
		}
	}

}
