package com.yjc.www.service.impl;

import com.yjc.www.dao.IShopDao;
import com.yjc.www.dao.impl.ShopDaoImpl;
import com.yjc.www.po.Customer;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;
import com.yjc.www.service.IShopService;

import java.util.List;

public class ShopServiceImpl implements IShopService {

    IShopDao dao = new ShopDaoImpl();

    @Override
    public Integer login(String password, String username) {
        //封装对象Shop
        return dao.login(password, username);
    }

    @Override
    public List<Shop> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Order> getShopOrder(Integer shopId) {
        return dao.getShopOrder(shopId);
    }

    @Override
    public void register(Shop shop) {
        dao.save(shop);
    }

    @Override
    public boolean checkName(String name) {
        return dao.checkName(name);
    }

    @Override
    public void update(Shop shop) {
        dao.update(shop);
    }

    @Override
    public Shop getById(Integer shopId) {
        return dao.get(shopId);
    }

    @Override
    public List<Goods> getGoods(Integer shopId) {
        return dao.getGoods(shopId);
    }
}
