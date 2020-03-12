package com.yjc.www.controller.customer;

import com.yjc.www.po.Order;
import com.yjc.www.service.ICustomerService;
import com.yjc.www.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerOrderServlet")
public class CustomerOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = (Integer) request.getSession().getAttribute("CustomerId");
        //调用CustomerService查询
        ICustomerService service = new CustomerServiceImpl();
        List<Order> orders = service.getCustomerOrder(customerId);
        //将order存入request域
        request.setAttribute("CustomerOrder", orders);
        //转发到jsp
        request.getRequestDispatcher("/customerOrder.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
