package com.zmy.dao;

import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;

import java.util.List;

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
     *  设置账户权限
     *
     * @param username 用户名
     */
    void SetAdmin(String username,String role);

    /**
     *  获取所有栏目
     *
     * @return
     */
    List<Colunmn> getAllColunmn();

    /**
     *  给新注册的用户所有栏目权限
     *
     * @param account
     */
    void authtoAccount(Account account);

    /**
     *  查询所有账户
     *
     * @return
     */
    List<Account> QueryAllAccount();

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
    int delAccount(String username);

    /**
     *
     * @param username 原用户名
     * @param editName 修改后的用户名
     * @param password 密码
     * @return 修改的条数
     */
    int changeAccount(String username,String editName,String password);

    /**
     *  根据栏目名称获取栏目id
     *
     * @param colunmns
     * @return
     */
    List<Integer> getColIdByColName(String...colunmns);

    /**
     *  给指定用户名账户授栏目权限
     *
     * @param username 用户名
     * @param colunmns 栏目权限
     */
    int grantColunmntoAccount(String username,String...colunmns);

    /**
     *  根据用户名获取账户信息  （模糊查询）
     *
     * @param username
     * @return
     */
    List<Account> getAccountByUserName(String username);
}
