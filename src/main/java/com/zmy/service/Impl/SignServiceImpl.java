package com.zmy.service.Impl;

import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.dao.AccountDao;
import com.zmy.pojo.Account;
import com.zmy.service.SignService;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 21:04
 */
public class SignServiceImpl implements SignService {
    private final AccountDao accountDao = new accountDaoImpl();

    /**
     * 注册
     *
     * @param account
     */
    @Override
    public void login(Account account) {
        // 调用accountDao中的方法
        accountDao.Login(account);
    }

    /**
     *  根据用户名获取用户信息，查看用户名是否可用
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public Account CheckUserName(String userName) {
        return accountDao.getAccountBuyUserName(userName);
    }

    /**
     *  根据用户名密码登录
     *
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    @Override
    public Account SignUp(String userName, String password) {
        Account account = null;
        account = accountDao.getAccountBuyUserName(userName);
        if (password.equals(account.getPassword())){
            return account;
        }
        return account;
    }

    /**
     *  通过手机号找回密码
     *
     * @param tel 手机号
     * @param password 新密码
     */
    @Override
    public int ChangePassword(String tel,String password) {
        return accountDao.ChangePasswordByTel(tel,password);
    }

}
