package com.yjc.www.dao;

import com.yjc.www.po.Customer;
import com.yjc.www.po.Order;

import java.util.List;

public interface ICustomerDao {
    /*
     * 保存顾客操作
     * @param customers 顾客对象
     */
    void save(Customer customer);
    /*
     * 删除指定id的顾客
     * @param customers 顾客对象
     */
    void delete(Customer customer);
    /*
     * 修改顾客操作
     * @param customers 带有id的顾客对象
     */
    void update(Customer customer);

    /*
     * 查询单个顾客操作
     * @param id 指定的顾客id
     * @return 顾客对象
     */
    Customer getById(Integer customerId);

    Integer login(String username, String password);

    boolean checkUsername(String username);

    Double getBalance(Integer customerId);

    void updateBalance(Double totalCost, Double balance, Integer customerId);

    /*
     * 多行查询操作
     * @return 封装有一个个顾客对象的list集合
     */
    List<Customer> getAll();

    List<Order> getCustomerOrder(Integer customerId);
}
