package com.yjc.www.controller.customer;

import com.yjc.www.po.Customer;
import com.yjc.www.po.Shop;
import com.yjc.www.service.ICustomerService;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.CustomerServiceImpl;
import com.yjc.www.service.impl.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerIndexServlet")
public class CustomerIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取customerId
        Integer customerId = (Integer) request.getSession().getAttribute("CustomerId");
        //获取service对象
        ICustomerService customerService = new CustomerServiceImpl();
        IShopService shopService = new ShopServiceImpl();
        //查找customer对象
        Customer customer = customerService.getById(customerId);
        //获取shop集合
        List<Shop> shops = shopService.getAll();
        //将customer与shops存入session
        request.getSession().setAttribute("customer", customer);
        request.getSession().setAttribute("shops", shops);
        //转发
        request.getRequestDispatcher("/customerIndex.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
