package com.zmy.dao;

import com.zmy.pojo.Account;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 17:11
 */
public interface AccountDao {

    /**
     *  根据登录账户获取头像
     *
     * @param username  用户名
     * @return
     */
    String getHeadPic(String username);

    /**
     *  下载头像
     *
     * @param username
     * @return
     */
    String DownloadPic(String username);

    /**
     * 注册
     * 将该账户添加入Account表中
     *
     * @param account 账户对象
     */
    void Login(Account account);

    /**
     *  将自己账户注销
     *
     * @param username
     */
    void Unsubscribe(String username);

    /**
     *  通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return
     */
    Account getAccountBuyUserName(String userName);

    /**
     *  通过手机号找回密码
     *
     * @param tel 手机号
     * @param password 新密码
     */
    int ChangePasswordByTel(String tel,String password);

    /**
     *  头像的图片名字存入数据库中
     *
     * @param username  用户名
     * @param fileName  图片名
     */
    void uploadPicture(String username,String fileName);
}
