package com.zmy.service.Impl;

import com.zmy.dao.AccountDao;
import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.service.AccountSaervice;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 9:48
 */
public class AccountSaerviceImpl implements AccountSaervice {

    private final AccountDao accountDao = new accountDaoImpl();

    /**
     *  注销自己账户
     *
     * @param username
     */
    @Override
    public void Unsubscribe(String username) {
        accountDao.Unsubscribe(username);
    }
}
