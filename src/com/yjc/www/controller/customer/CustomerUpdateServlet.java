package com.yjc.www.controller.customer;

import com.yjc.www.po.Customer;
import com.yjc.www.service.ICustomerService;
import com.yjc.www.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        //获取customerId
        Integer customerId = (Integer) request.getSession().getAttribute("CustomerId");
        //封装Customer
        Customer customer = new Customer(customerId, username, password, address, phone);
        //获取service
        ICustomerService service = new CustomerServiceImpl();
        //update
        service.update(customer);
        //查找customer
        Customer newCustomer = service.getById(customerId);
        //将customer存入session
        request.getSession().setAttribute("customer", newCustomer);
        //转发
        request.getRequestDispatcher("/customerById.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
