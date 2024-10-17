package com.controller.gigprice;

import com.model.GigPrice;
import com.service.interfaces.GigPriceService;
import com.service.impl.GigPriceServiceImpl;
import com.dao.impl.GigPriceDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gigprice/list")
public class GigPriceListServlet extends HttpServlet {
    private GigPriceService gigPriceService;

    @Override
    public void init() throws ServletException {
        gigPriceService = new GigPriceServiceImpl(new GigPriceDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gigId = Integer.parseInt(request.getParameter("gigId"));
        try {
            List<GigPrice> gigPrices = gigPriceService.getGigPricesByGigId(gigId);
            request.setAttribute("gigPrices", gigPrices);
            request.setAttribute("gigId", gigId);
            request.getRequestDispatcher("/WEB-INF/jsp/gigprice/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
