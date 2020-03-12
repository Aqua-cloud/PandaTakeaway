package com.yjc.www.service;

import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IOrderService {

    void acceptOrder(Integer orderId , Integer shopId);

    int placeOrder(Order order);
}
