package com.yjc.www.service;

import com.yjc.www.po.Customer;
import com.yjc.www.po.Order;

import java.util.List;

public interface ICustomerService {
    Integer login(String password, String username);

    List<Customer>  getAll();

    void  update(Customer customer);

    boolean checkUsername(String username);

    void register(Customer customer);

    List<Order> getCustomerOrder(Integer customerId);

    Customer getById(Integer customerId);
}
