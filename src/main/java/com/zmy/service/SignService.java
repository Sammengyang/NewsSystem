package com.zmy.service;

import com.zmy.pojo.Account;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 21:02
 */
public interface SignService {

    /**
     * 注册
     *
     * @param account
     */
    void login(Account account);

    /**
     *  根据用户名获取用户信息，查看用户名是否可用
     *
     * @param userName 用户名
     * @return
     */
    Account CheckUserName(String userName);

    /**
     *  根据用户名密码登录
     *
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    Account SignUp(String userName,String password);

    /**
     *  通过手机号找回密码
     *
     * @param tel 手机号
     * @param password 新密码
     */
    int ChangePassword(String tel,String password);
}
