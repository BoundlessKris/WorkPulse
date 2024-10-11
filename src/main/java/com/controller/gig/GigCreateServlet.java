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

@WebServlet("/gig/create")
public class GigCreateServlet extends HttpServlet {
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

        request.getRequestDispatcher("/WEB-INF/jsp/gig/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User user = (User) session.getAttribute("user");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int deliveryTime = Integer.parseInt(request.getParameter("deliveryTime"));
        // Add more fields as necessary

        Gig gig = new Gig();
        gig.setSellerId(user.getUserId());
        gig.setTitle(title);
        gig.setDescription(description);
        gig.setDeliveryTime(deliveryTime);
        // Set other fields

        try {
            Gig createdGig = gigService.createGig(gig);
            response.sendRedirect(request.getContextPath() + "/gig/details?id=" + createdGig.getGigId());
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/gig/create.jsp").forward(request, response);
        }
    }
}
