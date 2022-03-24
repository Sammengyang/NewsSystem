package com.zmy.service.Impl;

import com.zmy.dao.AuthDao;
import com.zmy.dao.Impl.AuthDaoImpl;
import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;
import com.zmy.service.AuthService;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 16:33
 */
public class AuthServiceImpl implements AuthService {
    private final AuthDao authDao = new AuthDaoImpl();


    /**
     *  设置账户权限
     *
     * @param username 用户名
     */
    @Override
    public void SetAdmin(String username,String role) {
        authDao.SetAdmin(username,role);
    }

    /**
     *  获取所有栏目
     *
     * @return
     */
    @Override
    public List<Colunmn> getAllColunmn() {
        return authDao.getAllColunmn();
    }

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
    public int delAccount(String username) {
        return authDao.delAccount(username);
    }

    /**
     *  修改账户
     *
     * @param username 原用户名
     * @param cusername 修改后的用户名
     * @param password 密码
     * @return 修改的条数
     */
    @Override
    public int changeAccount(String username, String cusername, String password) {
        return authDao.changeAccount(username,cusername,password);
    }

    /**
     *  获取所有账户信息
     *
     * @return
     */
    @Override
    public List<Account> getAllAccount() {
        return authDao.QueryAllAccount();
    }

    /**
     *  获取账户总数
     *
     * @return
     */
    @Override
    public Integer getCount() {
        return authDao.getCount();
    }

    /**
     *  分页查询账户信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Account> getAllAccountByPage(Integer pageNum, Integer pageSize) {
        return authDao.getAllAccountByPage(pageNum,pageSize);
    }

    /**
     *  给指定用户名账户授栏目权限
     *
     * @param username 用户名
     * @param colunmns 栏目权限
     */
    @Override
    public int grantColunmntoAccount(String username, String... colunmns) {
        return authDao.grantColunmntoAccount(username,colunmns);
    }

    /**
     *  获取用户名包含 username 的总条数
     *
     * @param username
     * @return
     */
    @Override
    public Integer getAcByUserNameCount(String username) {
        return authDao.getAcByUserNameCount(username);
    }

    /**
     *  根据用户名获取账户信息  （模糊查询）
     *
     * @param username
     * @return
     */
    @Override
    public List<Account> getAccountByUserName(String username) {
        return authDao.getAccountByUserName(username);
    }
}
