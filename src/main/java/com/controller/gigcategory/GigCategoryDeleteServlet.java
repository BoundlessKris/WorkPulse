package com.controller.gigcategory;

import com.model.User;
import com.service.interfaces.GigCategoryService;
import com.service.impl.GigCategoryServiceImpl;
import com.dao.impl.GigCategoryDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/gigcategory/delete")
public class GigCategoryDeleteServlet extends HttpServlet {
    private GigCategoryService gigCategoryService;

    @Override
    public void init() throws ServletException {
        gigCategoryService = new GigCategoryServiceImpl(new GigCategoryDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (!"admin".equals(user.getUserType())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have permission to perform this action");
            return;
        }

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        try {
            gigCategoryService.deleteCategory(categoryId);
            response.sendRedirect(request.getContextPath() + "/gigcategory/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/gigcategory/list");
        }
    }
}
