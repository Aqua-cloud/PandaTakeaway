package com.yjc.www.controller.shop;

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
import java.io.IOException;
import java.util.List;

@WebServlet("/goodsUpdateServlet")
public class GoodsUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String limitNum = request.getParameter("limitNum");
        String goodsId = request.getParameter("goodsId");
        //封装Goods
        Goods goods = new Goods(Integer.parseInt(goodsId), name, Double.parseDouble(price), Integer.parseInt(limitNum));
        //获取service
        IShopService shopService = new ShopServiceImpl();
        IGoodsService goodsService = new GoodsServiceImpl();
        //update
        goodsService.update(goods);
        //查找goods
        List<Goods> goodsList = shopService.getGoods(Integer.parseInt(goodsId));
        //将customer存入session
        request.getSession().setAttribute("goodsList", goodsList);
        //转发
        request.getRequestDispatcher("/shopIndex.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
