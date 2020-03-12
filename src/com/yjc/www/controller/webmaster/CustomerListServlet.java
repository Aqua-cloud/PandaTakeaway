package com.yjc.www.controller.webmaster;

import com.yjc.www.po.Customer;
import com.yjc.www.service.ICustomerService;
import com.yjc.www.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerListServlet")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用CustomerService查询
        ICustomerService service = new CustomerServiceImpl();
        List<Customer> customers = service.getAll();
        //将customers存入request域
        request.setAttribute("customers",customers);
        //转发到list.jsp
        request.getRequestDispatcher("/customerList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
