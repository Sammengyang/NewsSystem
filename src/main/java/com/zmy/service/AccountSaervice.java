package com.zmy.service;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 9:48
 */
public interface AccountSaervice {

    /**
     *  根据登录账户获取头像
     *
     * @param username  用户名
     * @return
     */
    String getHeadPic(String username);

    /**
     *  将自己账户注销
     *
     * @param username
     */
    void Unsubscribe(String username);
}
