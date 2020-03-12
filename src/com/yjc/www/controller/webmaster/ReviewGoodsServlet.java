package com.yjc.www.controller.webmaster;

import com.yjc.www.po.Goods;
import com.yjc.www.po.Shop;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.GoodsServiceImpl;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/reviewGoodsServlet")
public class ReviewGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String choice = request.getParameter("choice");
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Goods> goodsList = (List<Goods>) request.getSession().getAttribute("newGoods");
        Goods goods = goodsList.get(id - 1);
        System.out.println(goods);
        if ("pass".equals(choice)) {
            IGoodsService service = new GoodsServiceImpl();
            service.save(goods);
        }
        goodsList.remove(id - 1);
        response.sendRedirect(request.getContextPath() + "/reviewGoods.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
