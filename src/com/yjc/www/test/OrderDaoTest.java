package com.yjc.www.test;

import com.yjc.www.dao.IOrderDao;
import com.yjc.www.dao.impl.OrderDaoImpl;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDaoTest {

    //映入Dao层
    private IOrderDao dao = new OrderDaoImpl();

    @Test
    public void testSave() {
        Timestamp date = new Timestamp(new Date().getTime());
        Order orders = new Order( date, 1, 2, 2, 33.0 );
        dao.save(orders);
    }

    @Test
    public void testUpdate() {
        Timestamp date = new Timestamp(new Date().getTime());
        Order orders = new Order(date, 1, 2, 2, 15.0 );
        dao.update(orders);
    }

    @Test
    public void testDelete() {
        dao.delete(2);
    }

    @Test
    public void testGet() {
        Order order = dao.get(3);
        System.out.println(order);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(order.getOrderTime());//format()方法将Date转换成指定格式的String
        System.out.println(dateStr);

        System.out.println(order.getOrderTime());
    }


}
