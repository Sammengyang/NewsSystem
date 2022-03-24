package com.zmy.service;

import com.zmy.pojo.Account;

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

    /**
     *  通过用户名获取账户信息
     *
     * @param username
     * @return
     */
    Account getPrivateInfo(String username);

    /**
     *  修改账户信息
     *   根据原用户名修改该账户的个人信息
     *
     *  @param oldName  原用户名
     * @param username 现用户名
     * @param password 现密码
     * @param tel      现手机号
     * @return
     */
    int ChangeInfo(String oldName,String username,String password,String tel);
}
