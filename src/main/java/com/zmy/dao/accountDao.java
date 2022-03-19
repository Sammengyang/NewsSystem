package com.zmy.dao;

import com.zmy.pojo.Account;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 17:11
 */
public interface accountDao {

    /**
     * 注册
     * 将该账户添加入Account表中
     *
     * @param account 账户对象
     */
    void Login(Account account);
}
