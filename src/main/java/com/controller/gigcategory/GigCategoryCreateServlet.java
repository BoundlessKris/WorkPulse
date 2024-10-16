package com.controller.gigcategory;

import com.model.GigCategory;
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

@WebServlet("/gigcategory/create")
public class GigCategoryCreateServlet extends HttpServlet {
    private GigCategoryService gigCategoryService;

    @Override
    public void init() throws ServletException {
        gigCategoryService = new GigCategoryServiceImpl(new GigCategoryDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (!"admin".equals(user.getUserType())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have permission to access this resource");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/gigcategory/create.jsp").forward(request, response);
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

        String name = request.getParameter("name");
        String parentCategoryIdStr = request.getParameter("parentCategoryId");
        Integer parentCategoryId = parentCategoryIdStr.isEmpty() ? null : Integer.parseInt(parentCategoryIdStr);

        GigCategory category = new GigCategory();
        category.setName(name);
        category.setParentCategoryId(parentCategoryId);

        try {
            GigCategory createdCategory = gigCategoryService.createCategory(category);
            response.sendRedirect(request.getContextPath() + "/gigcategory/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/gigcategory/create.jsp").forward(request, response);
        }
    }
}