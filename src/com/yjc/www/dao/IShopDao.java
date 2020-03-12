package com.yjc.www.dao;

import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;


import java.util.List;

public interface IShopDao {

    void save( Shop shop);

    void delete(Integer id);

    void update(Shop shop);

    Shop get(Integer id);

    List<Goods> getGoods(Integer id);

    List<Shop> getAll();

    Integer login(String password, String username);

    List<Order> getShopOrder(Integer shopId);

    boolean checkName(String name);

    void updateTurnover(Integer shopId, Double turnover);
}
