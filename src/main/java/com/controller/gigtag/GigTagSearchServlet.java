//package com.controller.gigtag;
//
//import com.model.Gig;
//import com.service.interfaces.GigTagService;
//import com.service.impl.GigTagServiceImpl;
//import com.dao.impl.GigTagDaoImpl;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/gigtag/search")
//public class GigTagSearchServlet extends HttpServlet {
//    private GigTagService gigTagService;
//
//    @Override
//    public void init() throws ServletException {
//        gigTagService = new GigTagServiceImpl(new GigTagDaoImpl());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int gigId = Integer.parseInt(request.getParameter("gigId"));
//
//        // Corrected line: Handle case where limit parameter might be missing
//        int limit;
//        String limitParam = request.getParameter("limit");
//        if (limitParam != null && !limitParam.isEmpty()) {
//            limit = Integer.parseInt(limitParam);
//        } else {
//            limit = 5; // Default value
//        }
////        In this corrected version:
////
////We first get the "limit" parameter as a String.
////We check if the parameter is not null and not empty.
////If it's present and valid, we parse it to an integer.
////If it's not present or empty, we use a default value of 5.
//
//        try {
//            List<Gig> similarGigs = gigTagService.findSimilarGigs(gigId, limit);
//            request.setAttribute("similarGigs", similarGigs);
//            request.setAttribute("gigId", gigId);
//            request.getRequestDispatcher("/WEB-INF/jsp/gigtag/similarGigs.jsp").forward(request, response);
//        } catch (Exception e) {
//            request.setAttribute("error", "An error occurred: " + e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
//        }
//    }
//}
package com.controller.gigtag;

import com.model.Gig;
import com.service.interfaces.GigTagService;
import com.service.impl.GigTagServiceImpl;
import com.dao.impl.GigTagDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gigtag/search")
public class GigTagSearchServlet extends HttpServlet {
    private GigTagService gigTagService;

    @Override
    public void init() throws ServletException {
        gigTagService = new GigTagServiceImpl(new GigTagDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Validate and parse gigId
            int gigId;
            try {
                gigId = Integer.parseInt(request.getParameter("gigId"));
                if (gigId <= 0) {
                    throw new IllegalArgumentException("Invalid gig ID");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid gig ID format");
            }

            // Parse limit parameter
            int limit;
            String limitParam = request.getParameter("limit");
            if (limitParam != null && !limitParam.isEmpty()) {
                try {
                    limit = Integer.parseInt(limitParam);
                    if (limit <= 0) {
                        throw new IllegalArgumentException("Limit must be a positive integer");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid limit format");
                }
            } else {
                limit = 5; // Default value
            }

            List<Gig> similarGigs = gigTagService.findSimilarGigs(gigId, limit);
            request.setAttribute("similarGigs", similarGigs);
            request.setAttribute("gigId", gigId);
            request.getRequestDispatcher("/WEB-INF/jsp/gigtag/similarGigs.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
