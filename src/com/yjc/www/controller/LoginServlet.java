package com.yjc.www.controller;

import com.yjc.www.po.Customer;
import com.yjc.www.po.Shop;
import com.yjc.www.service.ICustomerService;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.IWebmasterService;
import com.yjc.www.service.impl.CustomerServiceImpl;
import com.yjc.www.service.impl.ShopServiceImpl;
import com.yjc.www.service.impl.WebmasterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String user = request.getParameter("user");
        //判断是否填完
        if (username.length() != 0 && password.length() != 0 && user != null) {
            //创建session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            switch (user) {
                case "customer": {
                    //调用CustomerService的方法
                    ICustomerService customerService = new CustomerServiceImpl();
                    Integer customerId = customerService.login(username, password);
                    //判断customer
                    if (customerId == null) {
                        //登录失败
                        response.sendRedirect(request.getContextPath() + "/loginFail.jsp");
                        return;
                    } else {
                        //登录成功
                        //存储数据
                        session.setAttribute("CustomerId", customerId);
                        //重定向
                        response.sendRedirect(request.getContextPath() + "/customerIndexServlet");
                        return;
                    }
                }
                case "shop": {
                    //调用ShopService的方法
                    IShopService shopService = new ShopServiceImpl();
                    Integer shopId = shopService.login(password, username);
                    //判断密码是否正确
                    if (shopId == null) {
                        //登录失败
                        response.sendRedirect(request.getContextPath() + "/loginFail.jsp");
                        return;
                    } else {
                        //登录成功
                        session.setAttribute("ShopId", shopId);
                        //重定向
                        response.sendRedirect(request.getContextPath() + "/shopIndexServlet");
                        return;
                    }
                }
                case "webmaster": {
                    //调用WebmasterService
                    IWebmasterService webmasterService = new WebmasterServiceImpl();
                    Integer webmasterId = webmasterService.login(password, username);
                    //判断密码是否正确
                    if (webmasterId == null) {
                        //登录失败
                        response.sendRedirect(request.getContextPath() + "/loginFail.jsp");
                        return;
                    } else {
                        //登录成功
                        session.setAttribute("WebmasterId", webmasterId);
                        //重定向
                        response.sendRedirect(request.getContextPath() + "/webmasterIndex.jsp");
                        return;
                    }
                }
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/unfilledFail.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
