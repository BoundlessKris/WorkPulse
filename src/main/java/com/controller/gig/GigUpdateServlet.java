package com.controller.gig;

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

@WebServlet("/gig/update")
public class GigUpdateServlet extends HttpServlet {
    private GigService gigService;

    @Override
    public void init() throws ServletException {
        gigService = new GigServiceImpl(new GigDaoImpl());
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
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have permission to edit this gig.");
                return;
            }

            request.setAttribute("gig", gig);
            request.getRequestDispatcher("/WEB-INF/jsp/gig/update.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int deliveryTime = Integer.parseInt(request.getParameter("deliveryTime"));
        // Add more fields as necessary

        try {
            Gig gig = gigService.getGigById(gigId);
            User user = (User) session.getAttribute("user");

            if (gig.getSellerId() != user.getUserId()) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have permission to edit this gig.");
                return;
            }

            gig.setTitle(title);
            gig.setDescription(description);
            gig.setDeliveryTime(deliveryTime);
            // Update other fields

            Gig updatedGig = gigService.updateGig(gig);
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + updatedGig.getGigId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/gig/update.jsp").forward(request, response);
        }
    }
}
