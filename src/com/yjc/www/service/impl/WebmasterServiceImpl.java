package com.yjc.www.service.impl;

import com.yjc.www.dao.IWebmasterDao;
import com.yjc.www.dao.impl.WebmasterDaoImpl;
import com.yjc.www.service.IWebmasterService;

public class WebmasterServiceImpl implements IWebmasterService {

    IWebmasterDao dao = new WebmasterDaoImpl();

    @Override
    public Integer login(String password, String username) {
        //封装对象Shop
        return dao.login(password,username);
    }

}
