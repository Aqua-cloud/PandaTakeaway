package com.yjc.www.test;

import com.yjc.www.po.Order;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IOrderService;
import com.yjc.www.service.impl.GoodsServiceImpl;
import com.yjc.www.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class OrderServiceTest {
    IOrderService service = new OrderServiceImpl();

    @Test
    public void testSave(){
        Timestamp date = new Timestamp(new Date().getTime());
        Order order = new Order(date,1,1,2,50);
        service.placeOrder(order);
        //date,customerId,goodsId,number,totalCost
    }

    @Test
    public void testDelete(){
        service.acceptOrder(18,1);
    }
}
