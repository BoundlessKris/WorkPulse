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
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/user/delete")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
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
