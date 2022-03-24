package com.zmy.service.Impl;

import com.zmy.dao.AccountDao;
import com.zmy.dao.Impl.accountDaoImpl;
import com.zmy.pojo.Account;
import com.zmy.service.AccountSaervice;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-23 9:48
 */
public class AccountSaerviceImpl implements AccountSaervice {

    private final AccountDao accountDao = new accountDaoImpl();

    @Override
    public String getHeadPic(String username) {
        return accountDao.getHeadPic(username);
    }

    /**
     *  注销自己账户
     *
     * @param username
     */
    @Override
    public void Unsubscribe(String username) {
        accountDao.Unsubscribe(username);
    }

    /**
     *  通过用户名获取账户信息
     *
     * @param username
     * @return
     */
    @Override
    public Account getPrivateInfo(String username) {
        return accountDao.getPrivateInfo(username);
    }

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
    @Override
    public int ChangeInfo(String oldName, String username, String password, String tel) {
        return accountDao.ChangeInfo(oldName,username,password,tel);
    }
}
