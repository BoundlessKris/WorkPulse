//package com.controller.dashboard;
//
//import com.model.User;
//import com.service.interfaces.*;
//import com.service.impl.*;
//import com.dao.impl.*;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/dashboard/admin")
//public class AdminDashboardServlet extends HttpServlet {
//    private UserService userService;
//    private OrderService orderService;
//    private GigService gigService;
//    private BuyerRequestService buyerRequestService;
//
//    @Override
//    public void init() throws ServletException {
//        userService = new UserServiceImpl(new UserDaoImpl());
//        orderService = new OrderServiceImpl(new OrderDaoImpl());
//        gigService = new GigServiceImpl(new GigDaoImpl());
//        buyerRequestService = new BuyerRequestServiceImpl(new BuyerRequestDaoImpl());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            response.sendRedirect(request.getContextPath() + "/user/login");
//            return;
//        }
//
//        User user = (User) session.getAttribute("user");
//        if (!"admin".equals(user.getUserType())) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
//            return;
//        }
//
//        try {
//            int totalUsersCount = userService.getTotalUsersCount();
//            int totalBuyersCount = userService.getTotalBuyersCount();
//            int totalSellersCount = userService.getTotalSellersCount();
//            int totalOrdersCount = orderService.getTotalOrdersCount();
//            double totalRevenue = orderService.getTotalRevenue();
//            int totalActiveGigsCount = gigService.getTotalActiveGigsCount();
//            int totalActiveBuyerRequestsCount = buyerRequestService.getTotalActiveBuyerRequestsCount();
//
//            request.setAttribute("totalUsersCount", totalUsersCount);
//            request.setAttribute("totalBuyersCount", totalBuyersCount);
//            request.setAttribute("totalSellersCount", totalSellersCount);
//            request.setAttribute("totalOrdersCount", totalOrdersCount);
//            request.setAttribute("totalRevenue", totalRevenue);
//            request.setAttribute("totalActiveGigsCount", totalActiveGigsCount);
//            request.setAttribute("totalActiveBuyerRequestsCount", totalActiveBuyerRequestsCount);
//
//            request.getRequestDispatcher("/WEB-INF/jsp/dashboard/admin.jsp").forward(request, response);
//        } catch (Exception e) {
//            request.setAttribute("error", "An error occurred: " + e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
//        }
//    }
//}
