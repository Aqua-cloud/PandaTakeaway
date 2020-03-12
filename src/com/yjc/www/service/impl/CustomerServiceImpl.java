package com.yjc.www.service.impl;

import com.yjc.www.dao.ICustomerDao;
import com.yjc.www.dao.impl.CustomerDaoImpl;
import com.yjc.www.po.Customer;
import com.yjc.www.po.Order;
import com.yjc.www.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerDao dao = new CustomerDaoImpl();

    @Override
    public Integer login(String password, String username) {
        //封装对象Customer
        return dao.login(password, username);
    }

    @Override
    public List<Customer> getAll() {
        return dao.getAll();
    }

    @Override
    public void update(Customer customer) {
        dao.update(customer);
    }

    @Override
    public boolean checkUsername(String username) {
        return dao.checkUsername(username);
    }

    @Override
    public void register(Customer customer) {
        dao.save(customer);
    }

    @Override
    public List<Order> getCustomerOrder(Integer customerId) {
        return dao.getCustomerOrder(customerId);
    }

    @Override
    public Customer getById(Integer customerId) {
        return dao.getById(customerId);
    }


}
