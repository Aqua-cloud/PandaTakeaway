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

@WebServlet("/deleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("goodsId");
        int goodsId = Integer.parseInt(id);
        //获取shopId
        Integer shopId = (Integer) request.getSession().getAttribute("ShopId");
        //调用GoodsService删除
        IGoodsService goodsService = new GoodsServiceImpl();
        goodsService.delete(goodsId);
        //调用shopService查询
        IShopService shopService = new ShopServiceImpl();
        List<Goods> goodsList = shopService.getGoods(shopId);
        //将goodsList存入session
        request.getSession().setAttribute("goodsList", goodsList);
        //重定向
        response.sendRedirect(request.getContextPath() + "/shopIndex.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
