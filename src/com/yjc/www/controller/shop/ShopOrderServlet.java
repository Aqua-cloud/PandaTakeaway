package com.yjc.www.controller.shop;

import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shopOrderServlet")
public class ShopOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer shopId = (Integer)request.getSession().getAttribute("ShopId");
        //调用ShopService查询
        IShopService service = new ShopServiceImpl();
        Shop shop = service.getById(shopId);
        List<Order> orders = service.getShopOrder(shopId);
        //将order存入request域
        request.setAttribute("ShopOrder",orders);
        //更新shop
        request.getSession().setAttribute("shop", shop);
        //转发到list.jsp
        request.getRequestDispatcher("/shopOrder.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
