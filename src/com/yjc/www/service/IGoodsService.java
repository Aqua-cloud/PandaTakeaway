package com.yjc.www.service;

import com.yjc.www.po.Goods;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IGoodsService {

    List<Goods>  getAll();

    Double getPrice(Integer goodsId);

    void update(Goods goods);

    Goods getById(int goodsId);

    void save(Goods goods);

    void delete(Integer goodsId);

    void updateNum(Integer goodsId, Integer number);
}
