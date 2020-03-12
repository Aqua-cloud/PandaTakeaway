package com.yjc.www.dao;

import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;

import java.util.List;

public interface IOrderDao {

    void save(Order order);

    void delete(Integer id);

    void update(Order order);

    Order get(Integer id);

    Double getTotalCost(Integer id);

}
