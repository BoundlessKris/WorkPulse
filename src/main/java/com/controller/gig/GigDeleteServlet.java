package com.controller.gig;

import com.dao.impl.OrderDaoImpl;
import com.dao.impl.ReviewDaoImpl;
import com.model.Gig;
import com.model.User;
import com.service.interfaces.GigService;
import com.service.impl.GigServiceImpl;
import com.dao.impl.GigDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/gig/delete")
public class GigDeleteServlet extends HttpServlet {
    private GigService gigService;

    @Override
    public void init() throws ServletException {
        GigDaoImpl gigDao = new GigDaoImpl();
        ReviewDaoImpl reviewDao = new ReviewDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        gigService = new GigServiceImpl(gigDao, reviewDao, orderDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int gigId = Integer.parseInt(request.getParameter("id"));
        try {
            Gig gig = gigService.getGigById(gigId);
            User user = (User) session.getAttribute("user");

            if (gig.getSellerId() != user.getUserId()) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have permission to delete this gig.");
                return;
            }

            request.setAttribute("gig", gig);
            request.getRequestDispatcher("/WEB-INF/jsp/gig/delete.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Gig not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        int gigId = Integer.parseInt(request.getParameter("gigId"));
        try {
            Gig gig = gigService.getGigById(gigId);
            User user = (User) session.getAttribute("user");

            if (gig.getSellerId() != user.getUserId()) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have permission to delete this gig.");
                return;
            }

            gigService.deleteGig(gigId);
            response.sendRedirect(request.getContextPath() + "/gig/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/gig/delete.jsp").forward(request, response);
        }
    }
}
