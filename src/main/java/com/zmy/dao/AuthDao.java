package com.zmy.dao;

import com.zmy.pojo.Account;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 21:29
 */
public interface AuthDao {
/*
    **
     *  向role表中添加角色权限
     *
     * @param userName 账户id
     * @param roid
     /
    void addAccountRole(String userName,int [] roid);

    **
     *  根据userName修改角色权限
     *
     * @param userName
     * @param roid
    */
//    void UpdateAccountRole(String userName,int [] roid);

    /**
     *  给新注册的用户所有栏目权限
     *
     * @param account
     */
    void authtoAccount(Account account);

    /**
     *  添加账户
     *
     * @param username 用户名
     * @param password 密码
     */
    void addAccount(String username,String password);

    /**
     *  根据用户名删除用户
     *
     * @param username
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
