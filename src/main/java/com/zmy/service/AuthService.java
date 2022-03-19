package com.zmy.service;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 16:32
 */
public interface AuthService {

    /**
     *  添加账户
     *
     * @param username 用户名
     * @param password 密码
     */
    void addAccount(String username,String password);

    /**
     *  根据用户名删除账户
     *
     * @param username 用户名
     */
    void delAccount(String username);


    /**
     *  修改账户
     *
     * @param username 原用户名
     * @param cusername 修改后的用户名
     * @param password 密码
     */
    void changeAccount(String username,String cusername,String password);
}
