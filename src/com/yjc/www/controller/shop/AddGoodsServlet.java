package com.yjc.www.controller.shop;

import com.yjc.www.po.Goods;
import com.yjc.www.po.Shop;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String limitNum = request.getParameter("limitNum");
        //判断所填信息是否为空
        if (name.length() != 0 && price.length() != 0 && limitNum.length() != 0) {
            //获取session
            HttpSession session = request.getSession();
            //获取集合newGoods
            List<Goods> newGoods = (ArrayList) session.getAttribute("newGoods");
            //获取shopName,封装goods
            Goods goods = new Goods(name, Double.parseDouble(price), Integer.parseInt(limitNum));
            Shop shop = (Shop) session.getAttribute("shop");
            String shopName = shop.getName();
            Integer shopId = shop.getId();
            goods.setShopName(shopName);
            goods.setShopId(shopId);
            //添加到集合中
            newGoods.add(goods);
            //存到session
            session.setAttribute("newGoods", newGoods);
            response.sendRedirect(request.getContextPath() + "/registering.jsp");
            return;
        } else {
            response.sendRedirect(request.getContextPath() + "/goodsUnfilled.jsp");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
