package com.controller.file;

import com.model.File;
import com.model.User;
import com.service.interfaces.FileService;
import com.service.impl.FileServiceImpl;
import com.dao.impl.FileDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@WebServlet("/file/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100)  // 100 MB
public class FileUploadServlet extends HttpServlet {
    private FileService fileService;
    private static final String UPLOAD_DIRECTORY = "uploads";

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
        String uploadPath = getServletContext().getRealPath("") + java.io.File.separator + UPLOAD_DIRECTORY;
        java.io.File uploadDir = new java.io.File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        try {
            for (Part part : request.getParts()) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                String filePath = uploadPath + java.io.File.separator + fileName;
                part.write(filePath);

                File file = new File();
                file.setUserId(user.getUserId());
                file.setFileType(part.getContentType());
                file.setFilePath(UPLOAD_DIRECTORY + java.io.File.separator + fileName);
                file.setUploadedAt(LocalDateTime.now());

                fileService.uploadFile(file);
            }
            response.sendRedirect(request.getContextPath() + "/file/list");
        } catch (Exception e) {
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/file/upload.jsp").forward(request, response);
    }
}
