package com.yjc.www.controller.webmaster;

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

@WebServlet("/reviewRegistrationServlet")
public class ReviewRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取session
        HttpSession session = request.getSession();
        List<String> choices = (ArrayList) session.getAttribute("choices");
        List<Shop> shops =(ArrayList<Shop>) session.getAttribute("shopList");
            for (int i = 0; i < shops.size(); i++) {
                if ("pass".equals(request.getParameter(choices.get(i)))) {
                    IShopService service = new ShopServiceImpl();
                    service.register(shops.get(i));
                }
                shops.remove(i);
            }
            session.setAttribute("shops", shops);
            response.sendRedirect(request.getContextPath() + "/reviewRegistration.jsp");
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
