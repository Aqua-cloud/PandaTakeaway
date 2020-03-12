package com.yjc.www.test;

import com.yjc.www.dao.IShopDao;
import com.yjc.www.dao.impl.ShopDaoImpl;
import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;
import org.junit.Test;

import java.util.List;

public class ShopDaoTest {

        //映入DAO层
        private IShopDao dao = new ShopDaoImpl();

        @Test
        public void testSave() {
            Shop shop =new Shop(1,"必胜客",1500,"88580069","北京","4321","五星");
            dao.save(shop);
        }

        @Test
        public void testDelete(){
            dao.delete(3);
        }

        @Test
        public void testUpdate(){
            Shop shop =new Shop(1,"必胜客",1500,"88580069","广州","4321","五星");
            dao.update(shop);
        }

        @Test
        public void testGet(){
            Shop shop = dao.get(2);
            System.out.println(shop);
        }

        @Test
        public void testGetAll(){
            List<Order> orders= dao.getShopOrder(1);
            for (Order order : orders) {
                System.out.println(order);
            }
        }
}
