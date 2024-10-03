package com.controller.user;

import com.model.User;
import com.dao.impl.UserDaoImpl;
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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(new UserDaoImpl());
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		String password = request.getParameter("password");

		try {
			User user = userService.login(username, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/dashboard");
			} else {
				request.setAttribute("error", "Invalid username or password");
				request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "An error occurred: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
		}
	}

}
