package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.AuthDao;
import com.zmy.dao.ColunmnDao;
import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 15:17
 */
public class AuthDaoImpl implements AuthDao {
    private final ColunmnDao colunmnDao = new ColunmnDaoImpl();

    /**
     *  给用户赋初始权限
     *
     */
    @Override
    public void authtoAccount(Account account) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "insert into user_col (userName,ColId) values(?,?)";
            ps = con.prepareStatement(sql);
            List<Colunmn> colList = colunmnDao.getColList();
            int count = colList.size();
            while (count -1 >=0){
                ps.setObject(1,account.getUserName());
                ps.setObject(2,colList.get(count-1).getColid());
                count--;
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
    }

    /**
     *  添加账户
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void addAccount(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Account account = new Account(username,password);
            con = DBUtil.getCon();
            String sql = "insert into account(userName,password) values (?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            ps.setObject(2,password);
            ps.executeUpdate();
            // 赋初始权限
            authtoAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
    }

    /**
     *  根据用户名删除用户
     *
     * @param username
     */
    @Override
    public void delAccount(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "delete from account where userName=?";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
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
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update account set userName=?,password=? where userName=?";
            ps.setObject(1,cusername);
            ps.setObject(2,password);
            ps.setObject(3,password);
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
    }
}
