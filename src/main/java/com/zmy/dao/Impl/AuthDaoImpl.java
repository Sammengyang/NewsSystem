package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.AuthDao;
import com.zmy.dao.ColunmnDao;
import com.zmy.pojo.Account;
import com.zmy.pojo.Colunmn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 15:17
 */
public class AuthDaoImpl implements AuthDao {
    private final ColunmnDao colunmnDao = new ColunmnDaoImpl();

    /**
     *  获取所有栏目
     *
     * @return
     */
    @Override
    public List<Colunmn> getAllColunmn() {
        List<Colunmn> colunmnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Colunmn colunmn = new Colunmn(
                  rs.getInt("colId"),
                  rs.getString("colName")
                );
                colunmnList.add(colunmn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return colunmnList;
    }

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
     *  查询所有账户
     *
     * @return
     */
    @Override
    public List<Account> QueryAllAccount() {
        List<Account> accountList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from account";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){ // 获取每行的数据信息
                String username = rs.getString("userName");
                Account account = new Account(
                        username,
                        rs.getString("password"),
                        rs.getString("tel"),
                        rs.getString("role")
                        );
                // 再根据用户名获取账户栏目权限
                List<Colunmn> colunmnList = colunmnDao.getColListByuserName(username);
                // 将获取的栏目权限集合赋给对应账户
                account.setColunmns(colunmnList);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return accountList;
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
            String sql = "insert into account(userName,password,role) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            ps.setObject(2,password);
            ps.setObject(3,2);
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
    public int delAccount(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        int count =0;
        try {
            con = DBUtil.getCon();
            String sql = "delete from account where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return count;
    }

    /**
     *
     * @param username 原用户名
     * @param editName 修改后的用户名
     * @param password 密码
     * @return 修改的条数
     */
    @Override
    public int changeAccount(String username, String editName, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = DBUtil.getCon();
            String sql = "update account set userName=?,password=? where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,editName);
            ps.setObject(2,password);
            ps.setObject(3,username);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return count;
    }

    /**
     *  根据栏目名称获取栏目id
     *
     * @param colunmns
     * @return
     */
    @Override
    public List<Integer> getColIdByColName(String... colunmns) {
        int count = colunmns.length;
        List<Integer> colIds = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            rs = null;
            String sql = "select * from colunmn where ColName=?";
            ps = con.prepareStatement(sql);
            // 预编译sql语句
            for (int i = 0; i < colunmns.length; i++) {
                ps.setObject(1,colunmns[i]);
                rs = ps.executeQuery();
                if (rs.next()){
                    colIds.add(rs.getInt("colId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return colIds;
    }


    /**
     *  给指定用户名账户授栏目权限
     *
     * @param username 用户名
     * @param colunmns 栏目权限
     */
    @Override
    public int grantColunmntoAccount(String username, String... colunmns) {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0; // 修改的数据条数
        try {
            con = DBUtil.getCon();
            // 先将原有的权限删除
            String sql = "delete from user_col where userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            ps.executeUpdate();
            if (ps!=null)
                ps.close();
            // 根据栏目名称获取栏目id
            List<Integer> colIds = getColIdByColName(colunmns);
            String sql1 = "insert into user_col (userName,ColId) values (?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            // 将栏目权限循环插入数据库
            for (int i = 0; i < colIds.size(); i++) {
                ps1.setObject(1,username);
                ps1.setObject(2,colIds.get(i));
                ps1.executeUpdate();
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return count;
    }
}
