package com.yjc.www.dao;

import com.yjc.www.po.Webmaster;

import java.util.List;

public interface IWebmasterDao {

    void save(Webmaster webmaster);

    void delete(Integer id);

    void update(Webmaster webmaster);

    Webmaster get(Integer id);

    Integer login(String password, String username);

    List<Webmaster> getAll();


}
