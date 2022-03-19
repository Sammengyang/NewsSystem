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

    /**
     *  通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return
     */
    Account getAccountBuyUserName(String userName);

    /**
     *  通过手机号找回密码
     *
     * @param tel 手机号
     * @param password 新密码
     */
    int ChangePasswordByTel(String tel,String password);
}
