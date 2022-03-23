package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.AuthDao;
import com.zmy.dao.ColunmnDao;
import com.zmy.dao.AccountDao;
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
public class accountDaoImpl implements AccountDao {
    private final ColunmnDao colunmnDao = new ColunmnDaoImpl();

    @Override
    public String getHeadPic(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select img from account where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("img");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }

    /**
     *  下载头像
     *
     * @param username
     * @return
     */
    @Override
    public String DownloadPic(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select img from account where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("img");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }

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
            String sql = "insert into Account (userName,name ,tel,password,role)values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1,account.getUserName());
            ps.setObject(2,account.getName());
            ps.setObject(3,account.getTel());
            ps.setObject(4,account.getPassword());
            ps.setObject(5,2);
            ps.executeUpdate();
            // 给用户受初始权限
            AuthDao authDao = new AuthDaoImpl();
            authDao.authtoAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }

    }

    /**
     *   注销自己账户
     *  删除手机号和密码
     * @param username
     */
    @Override
    public void Unsubscribe(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update account set tel='',password='' where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
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

    /**
     *  头像的图片名字存入数据库中
     *
     * @param username  用户名
     * @param fileName  图片名
     */
    @Override
    public void uploadPicture(String username, String fileName) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update account set img=? where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,fileName);
            ps.setObject(2,username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
    }
}
