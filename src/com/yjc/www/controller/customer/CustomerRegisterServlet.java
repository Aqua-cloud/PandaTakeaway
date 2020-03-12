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

@WebServlet("/customerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("GBK");
        response.setHeader("contentType", "text/html;charset=GBK");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        //调用CustomerService
        ICustomerService service = new CustomerServiceImpl();
        if (username.length() != 0 && password.length() != 0 && address.length() != 0 && phone.length() != 0) {
            if (service.checkUsername(username)) {
                Customer customer = new Customer();
                customer.setUsername(username);
                customer.setPassword(password);
                customer.setAddress(address);
                customer.setPhone(phone);
                service.register(customer);
                response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
                return;
            } else {
                response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
                return;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/registerUnfilled.jsp");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
