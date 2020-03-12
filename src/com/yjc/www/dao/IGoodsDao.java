package com.yjc.www.dao;

import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;

import java.util.Date;
import java.util.List;

public interface IGoodsDao {

    void save(Goods goods);

    void delete(Integer id);

    void update(Goods goods);

    Goods get(Integer id);

    Integer getLimitNum(Integer goodsId);

    Double getPrice(Integer goodsId);

    void updateNum(Integer number, Integer limitNum, Integer goodsId);

    List<Goods> getAll();

}
