package com.zmy.service.Impl;

import com.zmy.dao.AuthDao;
import com.zmy.dao.Impl.AuthDaoImpl;
import com.zmy.service.AuthService;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 16:33
 */
public class AuthServiceImpl implements AuthService {
    private final AuthDao authDao = new AuthDaoImpl();

    /**
     *  添加用户
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void addAccount(String username, String password) {
        authDao.addAccount(username,password);
    }

    /**
     *  根据用户名删除用户
     *
     * @param username 用户名
     */
    @Override
    public void delAccount(String username) {
        authDao.delAccount(username);
    }

    /**
     *  修改账户
     *
     * @param username 原用户名
     * @param cusername 修改后的用户名
     * @param password 密码
     */
    @Override
    public void changeAccount(String username, String cusername, String password) {
        authDao.changeAccount(username,cusername,password);
    }
}
