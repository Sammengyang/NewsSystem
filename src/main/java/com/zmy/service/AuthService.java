package com.zmy.service;

import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 16:32
 */
public interface AuthService {


    /**
     *  将该账户设置为管理员
     *
     * @param username 用户名
     */
    void SetAdmin(String username);

    /**
     *  获取所有栏目
     *
     * @return
     */
    List<Colunmn> getAllColunmn();

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
    int delAccount(String username);


    /**
     *  修改账户
     *
     * @param username 原用户名
     * @param cusername 修改后的用户名
     * @param password 密码
     * @return 修改的条数
     */
    int changeAccount(String username,String cusername,String password);

    /**
     *  获取所有账户信息
     *
     * @return
     */
    List<Account> getAllAccount();

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
