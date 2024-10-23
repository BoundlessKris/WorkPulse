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

@WebServlet("/file/delete")
public class FileDeleteServlet extends HttpServlet {
    private FileService fileService;

    @Override
    public void init() throws ServletException {
        fileService = new FileServiceImpl(new FileDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        int fileId = Integer.parseInt(request.getParameter("fileId"));

        try {
            File file = fileService.getFileById(fileId);
            if (!fileService.isFileBelongsToUser(fileId, user.getUserId())) {
                throw new IllegalStateException("You are not authorized to delete this file");
            }

            fileService.deleteFile(fileId);

            // Delete the physical file
            String filePath = getServletContext().getRealPath("") + java.io.File.separator + file.getFilePath();
            java.io.File physicalFile = new java.io.File(filePath);
            if (physicalFile.exists()) {
                physicalFile.delete();
            }

            response.sendRedirect(request.getContextPath() + "/file/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/file/list");
        }
    }
}
