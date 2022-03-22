package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.Utils.DateUtil;
import com.zmy.dao.ColunmnDao;
import com.zmy.dao.NewsDao;
import com.zmy.pojo.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-22 22:02
 */
public class NewsDaoImpl implements NewsDao {

    private final ColunmnDao colunmnDao = new ColunmnDaoImpl();

    /**
     *  随机产生一个新闻编号
     *
     * @return
     */
    @Override
    public Integer RandomNewsId() {
        Random random = new Random();
        // 存储新闻id
        List<Integer> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select newId from news";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(rs.getInt("newId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        Integer newId = random.nextInt(899999)+100000;
        while (list.contains(newId)){
            newId = random.nextInt(899999)+100000;
        }
        return newId;
    }

    @Override
    public List<News> getAllNews() {
        return null;
    }

    /**
     *  发布新闻
     *
     * @param title     标题
     * @param colName   栏目
     * @param content   内容
     * @param userName  发布人
     */
    @Override
    public void postNew(String title, String colName, String content,String userName) {
        // 随机产生新闻id
        Integer newsId = RandomNewsId();
        Connection con = null;
        PreparedStatement ps1 = null;
        try {
            // 获取当前时间
            Date date = new Date();
            String postTime = DateUtil.format(date);
            con = DBUtil.getCon();
            String sql = "insert into news (newId,title,content,postTime,userName) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1,newsId);
            ps.setObject(2,title);
            ps.setObject(3,content);
            ps.setObject(4,postTime);
            ps.setObject(5,userName);
            ps.executeUpdate();
            if (ps!=null)
                ps.close();
            // 再将新闻绑定发布的栏目
            // 获取栏目id
            Integer colId = colunmnDao.getColIdByColName(colName);
            String sql1 = "insert into new_col(newId,colId) values (?,?)";
            ps1 = con.prepareStatement(sql1);
            ps1.setObject(1,newsId);
            ps1.setObject(2,colId);
            ps1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps1);
        }
    }


}
