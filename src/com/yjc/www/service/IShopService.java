package com.yjc.www.service;

import com.yjc.www.po.Customer;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;

import java.util.List;

public interface IShopService {
    Integer login(String password, String username);

    List<Shop>  getAll();

    List<Order> getShopOrder(Integer shopId);

    void register(Shop shop);

    boolean checkName(String name);

    void update(Shop shop);

    Shop getById(Integer shopId);

    List<Goods> getGoods(Integer shopId);
}
