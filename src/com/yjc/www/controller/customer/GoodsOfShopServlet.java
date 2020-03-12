package com.yjc.www.controller.customer;

import com.yjc.www.po.Goods;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goodsOfShopServlet")
public class GoodsOfShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("shopId");
        int shopId = Integer.parseInt(id);
        //调用ShopService查询
        IShopService service = new ShopServiceImpl();
        List<Goods> goodsList = service.getGoods(shopId);
        //将goods存入request域
        request.setAttribute("goodsList", goodsList);
        //转发到jsp
        request.getRequestDispatcher("/goodsList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
