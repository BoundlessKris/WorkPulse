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
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

@WebServlet("/file/download")
public class FileDownloadServlet extends HttpServlet {
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

        int fileId = Integer.parseInt(request.getParameter("id"));

        try {
            File file = fileService.getFileById(fileId);
            String filePath = getServletContext().getRealPath("") + java.io.File.separator + file.getFilePath();

            response.setContentType(file.getFileType());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + Paths.get(file.getFilePath()).getFileName().toString() + "\"");

            try (InputStream in = new java.io.FileInputStream(filePath);
                 OutputStream out = response.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
        }
    }
}
