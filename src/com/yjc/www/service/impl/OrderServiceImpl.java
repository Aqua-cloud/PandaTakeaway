package com.yjc.www.service.impl;

import com.yjc.www.dao.ICustomerDao;
import com.yjc.www.dao.IGoodsDao;
import com.yjc.www.dao.IOrderDao;
import com.yjc.www.dao.IShopDao;
import com.yjc.www.dao.impl.CustomerDaoImpl;
import com.yjc.www.dao.impl.GoodsDaoImpl;
import com.yjc.www.dao.impl.OrderDaoImpl;
import com.yjc.www.dao.impl.ShopDaoImpl;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;
import com.yjc.www.service.ICustomerService;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IOrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements IOrderService {

    IGoodsDao goodsDao = new GoodsDaoImpl();
    IOrderDao orderDao = new OrderDaoImpl();
    ICustomerDao customerDao = new CustomerDaoImpl();
    IShopDao shopDao = new ShopDaoImpl();

    @Override
    public void acceptOrder(Integer orderId , Integer shopId) {
        Double totalCost = orderDao.getTotalCost(orderId);
        double turnover = shopDao.get(shopId).getTurnover();
        shopDao.updateTurnover(shopId,totalCost+turnover);
        orderDao.delete(orderId);
    }

    @Override
    public int placeOrder(Order order) {
        //获取基本参数
        int goodsId = order.getGoodsId();
        int number = order.getNumber();
        int customerId = order.getCustomerId();
        Double totalCost = order.getTotalCost();
        //获取余额并判断
        Double balance = customerDao.getBalance(customerId);
        if (balance - totalCost >= 0) {
            //获取存货并判断
            Integer limitNum = goodsDao.getLimitNum(goodsId);
            if (limitNum - number >= 0) {
                //更新余额
                customerDao.updateBalance(totalCost, balance, customerId);
                //更新存货
                goodsDao.updateNum(number, limitNum, goodsId);
                //存储订单
                orderDao.save(order);
                return 2;
            }
            return 1;
        }
        return 0;
    }
}
