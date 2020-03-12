package com.yjc.www.controller.shop;

import com.yjc.www.po.Shop;
import com.yjc.www.service.IShopService;
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

@WebServlet("/shopRegisterServlet")
public class ShopRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("GBK");
        response.setHeader("contentType","text/html;charset=GBK");
        //获取请求参数
        String name = request.getParameter("shop_name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String evaluation ="暂无评价";
        //调用ShopService
        IShopService service = new ShopServiceImpl();
        if(name.length() !=0 && password.length() != 0 && address.length() != 0 && phone.length() != 0 ) {
            if (service.checkName(name)){
                Shop shop = new Shop();
                HttpSession session = request.getSession();
                List<Shop> shopList =(ArrayList)session.getAttribute("shopList");
                shop.setName(name);
                shop.setPassword(password);
                shop.setAddress(address);
                shop.setPhone(phone);
                shop.setEvaluation(evaluation);
                shopList.add(shop);
                session.setAttribute("shopList",shopList);
                response.sendRedirect(request.getContextPath()+"/registering.jsp");
                return;
            }else {
                response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
                return;
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/registerUnfilled.jsp");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
