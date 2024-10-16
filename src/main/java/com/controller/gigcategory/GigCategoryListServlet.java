package com.controller.gigcategory;

import com.model.GigCategory;
import com.service.interfaces.GigCategoryService;
import com.service.impl.GigCategoryServiceImpl;
import com.dao.impl.GigCategoryDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/gigcategory/list")
public class GigCategoryListServlet extends HttpServlet {
    private GigCategoryService gigCategoryService;

    @Override
    public void init() throws ServletException {
        gigCategoryService = new GigCategoryServiceImpl(new GigCategoryDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<GigCategory> categories = gigCategoryService.getAllCategories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/WEB-INF/jsp/gigcategory/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
