package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.accountDao;
import com.zmy.pojo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            String sql = "insert into Accoumt (?,?,?,?)";
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
}
