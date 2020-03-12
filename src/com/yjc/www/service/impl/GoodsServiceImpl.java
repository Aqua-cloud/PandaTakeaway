package com.yjc.www.service.impl;

import com.yjc.www.dao.IGoodsDao;
import com.yjc.www.dao.impl.GoodsDaoImpl;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Shop;
import com.yjc.www.service.IGoodsService;
import com.yjc.www.service.IShopService;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    IGoodsDao dao = new GoodsDaoImpl();


    @Override
    public List<Goods> getAll() {
        return dao.getAll();
    }

    @Override
    public Double getPrice(Integer goodsId) {
        return dao.getPrice(goodsId);
    }

    @Override
    public void update(Goods goods) {
        dao.update(goods);
    }

    @Override
    public Goods getById(int goodsId) {
        return dao.get(goodsId);
    }

    @Override
    public void save(Goods goods) {
        dao.save(goods);
    }

    @Override
    public void delete(Integer goodsId) {
        dao.delete(goodsId);
    }

    @Override
    public void updateNum(Integer goodsId, Integer number) {
        Integer limitNum = dao.getLimitNum(goodsId);
        dao.updateNum(number,limitNum,goodsId);
    }


}
