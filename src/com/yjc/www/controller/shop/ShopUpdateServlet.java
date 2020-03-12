package com.yjc.www.controller.shop;

import com.yjc.www.po.Shop;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shopUpdateServlet")
public class ShopUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        //获取shopId
        Integer shopId = (Integer) request.getSession().getAttribute("ShopId");
        //封装Customer
        Shop shop = new Shop(shopId,name,password,address,phone);
        //获取service
        IShopService service = new ShopServiceImpl();
        //update
        service.update(shop);
        //查找shop
        Shop newShop = service.getById(shopId);
        //将customer存入session
        request.getSession().setAttribute("shop",newShop);
        //转发
        request.getRequestDispatcher("/shopById.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
