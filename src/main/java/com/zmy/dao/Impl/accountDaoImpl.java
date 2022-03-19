package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.accountDao;
import com.zmy.pojo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 22:12
 */
public class accountDaoImpl implements accountDao {

    /**
     * 注册
     * 将该账户添加入Account表中
     *
     * @param account 账户对象
     */
    @Override
    public void Login(Account account) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            // 将该账户插入 Account表中
            String sql = "insert into Account (userName,tel,password,role)values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1,account.getUserName());
            ps.setObject(2,account.getTel());
            ps.setObject(3,account.getPassword());
            ps.setObject(4,2);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }

    }

    /**
     *  通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public Account getAccountBuyUserName(String userName) {
        Account account = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from account where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,userName);
            rs = ps.executeQuery();
            if (rs.next()){
                account = new Account(
                        rs.getString("userName"),
                        rs.getString("Name"),
                        rs.getString("password"),
                        rs.getString("tel"),
                        rs.getString("role")
                );
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
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
    public int ChangePasswordByTel(String tel,String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update account set password=? where tel=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,password);
            ps.setObject(2,tel);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return 0;
    }
}
