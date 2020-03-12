package com.yjc.www.controller.shop;

import com.yjc.www.po.Goods;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.GoodsServiceImpl;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goodsByIdServlet")
public class GoodsByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("goodsId");
        int goodsId = Integer.parseInt(id);
        //调用ShopService查询
        IGoodsService service = new GoodsServiceImpl();
        Goods goods = service.getById(goodsId);
        //将goods存入request域
        request.setAttribute("goods", goods);
        //转发到jsp
        request.getRequestDispatcher("/goodsUpdate.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
