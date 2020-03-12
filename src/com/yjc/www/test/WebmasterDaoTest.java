package com.yjc.www.test;

import com.yjc.www.dao.IWebmasterDao;
import com.yjc.www.dao.impl.WebmasterDaoImpl;
import com.yjc.www.po.Webmaster;
import org.junit.Test;

import java.util.List;

public class WebmasterDaoTest {
    //映入Dao层
    private IWebmasterDao dao = new WebmasterDaoImpl();

    @Test
    public void testSave() {
        Webmaster webmaster = new Webmaster(2, "小明", "123465");
        dao.save(webmaster);
    }

    @Test
    public void testDelete(){
        dao.delete(2);
    }

    @Test
    public void testUpdate(){
        Webmaster webmaster = new Webmaster(1, "小王", "123465");
        dao.save(webmaster);
    }

    @Test
    public void testGet(){
        System.out.println(dao.get(1));
    }

    @Test
    public void testGetAll(){
        List<Webmaster> webmasters = dao.getAll();
        for (Webmaster wb: webmasters) {
            System.out.println(wb);
        }
    }
}
