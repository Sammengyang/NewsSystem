package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.ColunmnDao;
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
 * @create 2022-03-19 15:00
 */
public class ColunmnDaoImpl implements ColunmnDao {


    /**
     *  获取栏目总数
     *
     * @return
     */
    @Override
    public Integer getColunmnCount() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "select count(colId) count from colunmn";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return 0;
    }

    /**
     *  获取所有栏目编号和名字
     *
     * @return
     */
    @Override
    public List<Colunmn> getColList() {
        List<Colunmn> colunmnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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
            DBUtil.closeAll(con,ps);
        }
        return colunmnList;
    }

    /**
     *  分页查询栏目
     *
     * @param pageNum   页数
     * @param pageSize  每页的个数
     * @return
     */
    @Override
    public List<Colunmn> getAllColunmnByPage(Integer pageNum, Integer pageSize) {
        // 计算起始位置
        Integer start = (pageNum - 1) * pageSize;
        List<Colunmn> colunmnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn limit ?,?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,start);
            ps.setObject(2,pageSize);
            ResultSet rs = ps.executeQuery();
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
            DBUtil.closeAll(con,ps);
        }
        return colunmnList;
    }

    /**
     *  根据用户名获取对应的栏目权限
     *
     * @param username 用户名
     * @return
     */
    @Override
    public List<Colunmn> getColListByuserName(String username) {
        List<Colunmn> colunmnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "select c.colId,c.colName from user_col uc,colunmn c where uc.ColId = c.colId and userName= ?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,username);
            ResultSet rs = ps.executeQuery();
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
            DBUtil.closeAll(con,ps);
        }
        return colunmnList;
    }

    /**
     *  添加栏目
     *
     * @param colId   栏目id
     * @param colName 栏目名称
     */
    @Override
    public int addColunmn(Integer colId, String colName) {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = DBUtil.getCon();
            String sql = "insert into colunmn (colId,colName) values (?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1,colId);
            ps.setObject(2,colName);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return count;
    }

    /**
     *  根据栏目id删除栏目
     *
     * @param colId 栏目id
     * @return
     */
    @Override
    public int delColunmn(Integer colId) {
        int count = 0; // 操作的数据条数
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "delete from colunmn where colId=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,colId);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return count;
    }

    /**
     *  根据id修改栏目信息
     *
     * @param colId    原栏目id
     * @param editId   修改的id
     * @param editName 修改的名字
     * @return
     */
    @Override
    public int editColunmn(Integer colId, Integer editId, String editName) {
        int count = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update colunmn set colId=?,colName=? where colId=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,editId);
            ps.setObject(2,editName);
            ps.setObject(3,colId);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return count;
    }

    /**
     *  通过栏目名称查询栏目  （模糊查询）
     *
     * @param colName
     * @return
     */
    @Override
    public List<Colunmn> SerchColunmnByColName(String colName) {
        List<Colunmn> colunmnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn where colName like ?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,"%"+colName+"%");
            ResultSet rs = ps.executeQuery();
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
            DBUtil.closeAll(con,ps);
        }
        return colunmnList;
    }

    /**
     *  根据栏目名称获取id
     *
     * @param colName 栏目名称
     * @return
     */
    @Override
    public Integer getColIdByColName(String colName) {
        Integer colId = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn where colName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,colName);
            rs = ps.executeQuery();
            if (rs.next()){
                colId = rs.getInt("colId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return colId;
    }


}
