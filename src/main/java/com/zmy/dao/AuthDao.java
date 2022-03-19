package com.zmy.dao;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 21:29
 */
public interface AuthDao {

    /**
     *  向role表中添加角色权限
     *
     * @param userName 账户id
     * @param roid
     */
    void addAccountRole(String userName,int [] roid);

    /**
     *  根据userName修改角色权限
     *
     * @param userName
     * @param roid
     */
    void UpdateAccountRole(String userName,int [] roid);
}
