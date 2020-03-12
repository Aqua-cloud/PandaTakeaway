package com.yjc.www.test;

import com.yjc.www.dao.IGoodsDao;
import com.yjc.www.dao.impl.GoodsDaoImpl;
import com.yjc.www.po.Goods;
import org.junit.Test;

import java.util.List;

public class GoodsDaoTest {

        //映入DAO层
        private IGoodsDao dao = new GoodsDaoImpl();


        @Test
        public void testSave() {
            Goods goods = new Goods(3,"拉面",3,25.0,20);
            dao.save(goods);
        }

        @Test
        public void testDelete() {
        dao.delete(1);
        }

        @Test
        public void testUpdate(){
            Goods goods = new Goods(4,"炒饭",2,33.0,20);
            dao.update(goods);
        }

        @Test
        public void testGet(){
            Goods gd = dao.get(2);
            System.out.println(gd);
        }

        @Test
        public void testList(){
            List<Goods> list= dao.getAll();
            for (Goods goods : list) {
                System.out.println(goods);
            }
        }

        @Test
        public void testUpdateNum(){
            dao.updateNum(10,20,1);
        }

        @Test
        public void testGetLimitNum(){
            Integer limitNum = dao.getLimitNum(1);
            System.out.println(limitNum);
        }
}
