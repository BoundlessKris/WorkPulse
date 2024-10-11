package com.controller.gig;

import com.dao.impl.OrderDaoImpl;
import com.dao.impl.ReviewDaoImpl;
import com.model.Gig;
import com.service.interfaces.GigService;
import com.service.impl.GigServiceImpl;
import com.dao.impl.GigDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gig/details")
public class GigDetailsServlet extends HttpServlet {
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
        int gigId = Integer.parseInt(request.getParameter("id"));
        try {
            Gig gig = gigService.getGigById(gigId);
            request.setAttribute("gig", gig);
            request.getRequestDispatcher("/WEB-INF/jsp/gig/details.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Gig not found");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
