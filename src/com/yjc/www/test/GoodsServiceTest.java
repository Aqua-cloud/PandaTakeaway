package com.yjc.www.test;

import com.yjc.www.dao.IGoodsDao;
import com.yjc.www.dao.impl.GoodsDaoImpl;
import com.yjc.www.po.Shop;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IShopService;
import com.yjc.www.service.impl.GoodsServiceImpl;
import com.yjc.www.service.impl.ShopServiceImpl;
import org.junit.Test;

public class GoodsServiceTest {
    IGoodsService service = new GoodsServiceImpl();
    IShopService shopService = new ShopServiceImpl();
    @Test
    public void testUpdateNum() {
        service.updateNum(1, 10);
    }

    @Test
    public void testGetById(){
        Shop shop = shopService.getById(1);
        System.out.println(shop);
    }
}

