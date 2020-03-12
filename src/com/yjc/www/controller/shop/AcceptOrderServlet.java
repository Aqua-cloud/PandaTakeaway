package com.yjc.www.controller.shop;

import com.yjc.www.service.IOrderService;
import com.yjc.www.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/acceptOrderServlet")
public class AcceptOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("orderId");
        int orderId = Integer.parseInt(id);
        //获取shopId
        Integer shopId = (Integer) request.getSession().getAttribute("ShopId");
        //调用OrderService
        IOrderService service = new OrderServiceImpl();
        service.acceptOrder(orderId, shopId);
        //重定向
        response.sendRedirect(request.getContextPath() + "/shopOrderServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
