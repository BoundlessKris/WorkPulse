package com.controller.file;

import com.model.File;
import com.model.User;
import com.service.interfaces.FileService;
import com.service.impl.FileServiceImpl;
import com.dao.impl.FileDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/file/list")
public class FileListServlet extends HttpServlet {
    private FileService fileService;

    @Override
    public void init() throws ServletException {
        fileService = new FileServiceImpl(new FileDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User user = (User) session.getAttribute("user");

        try {
            List<File> files = fileService.getFilesByUserId(user.getUserId());
            request.setAttribute("files", files);
            request.getRequestDispatcher("/WEB-INF/jsp/file/list.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
