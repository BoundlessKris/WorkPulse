package com.controller.user;

import com.dao.impl.UserDaoImpl;
import com.service.impl.UserServiceImpl;
import com.service.interfaces.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPasswordResetServlet
 */
@WebServlet("/user/resetPassword")
public class UserPasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPasswordResetServlet() {
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
