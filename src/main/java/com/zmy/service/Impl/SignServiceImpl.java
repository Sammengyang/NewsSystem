package com.zmy.service.Impl;

import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.dao.accountDao;
import com.zmy.pojo.Account;
import com.zmy.service.SignService;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 21:04
 */
public class SignServiceImpl implements SignService {
    private final accountDao accountDao = new accountDaoImpl();


    @Override
    public void login(Account account) {
        // 调用accountDao中的方法
        accountDao.Login(account);
    }
}
