package com.yjc.www.controller.shop;

import com.yjc.www.po.Goods;
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

@WebServlet("/shopIndexServlet")
public class ShopIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取shopId
        Integer shopId = (Integer) request.getSession().getAttribute("ShopId");
        //获取service对象
        IShopService service = new ShopServiceImpl();
        //获取shop与goodsList
        Shop shop = service.getById(shopId);
        List<Goods> goodsList = service.getGoods(shopId);
        //将customer与goodsList存入session
        request.getSession().setAttribute("shop", shop);
        request.getSession().setAttribute("goodsList", goodsList);
        //转发
        request.getRequestDispatcher("/shopIndex.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
