package com.yjc.www.controller.customer;

import com.yjc.www.po.Order;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IOrderService;
import com.yjc.www.service.impl.GoodsServiceImpl;
import com.yjc.www.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/businessServlet")
public class BusinessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取service
        IOrderService orderService = new OrderServiceImpl();
        IGoodsService goodsService = new GoodsServiceImpl();
        //获取请求参数
        String num = request.getParameter("num");
        String id = request.getParameter("goodsId");
        int number = Integer.parseInt(num);
        int goodsId = Integer.parseInt(id);
        //获取时间
        Timestamp date = new Timestamp(new Date().getTime());
        //计算总额
        Double price = goodsService.getPrice(goodsId);
        Double totalCost = number * price;
        //获取customerId
        Integer customerId = (Integer) request.getSession().getAttribute("CustomerId");
        //封装Order
        Order order = new Order(date, customerId, goodsId, number, totalCost);
        //下单操作
        int i = orderService.placeOrder(order);
        switch (i) {
            //余额不足
            case 0: {
                response.sendRedirect(request.getContextPath() + "/orderNoBalance.jsp");
                return;
            }
            //库存不足
            case 1: {
                response.sendRedirect(request.getContextPath() + "/orderNoStock.jsp");
                return;
            }
            //下单成功
            case 2: {
                response.sendRedirect(request.getContextPath() + "/orderSuccess.jsp");
                return;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
