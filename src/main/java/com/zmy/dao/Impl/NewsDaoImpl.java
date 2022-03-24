package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.Utils.DateUtil;
import com.zmy.dao.ColunmnDao;
import com.zmy.dao.NewsDao;
import com.zmy.pojo.Colunmn;
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
     * 随机产生一个新闻编号
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
            while (rs.next()) {
                list.add(rs.getInt("newId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        Integer newId = random.nextInt(899999) + 100000;
        while (list.contains(newId)) {
            newId = random.nextInt(899999) + 100000;
        }
        return newId;
    }

    /**
     * 获取登录人负责的新闻栏目
     *
     * @return
     */
    @Override
    public List<Colunmn> getRespColunmn(String username) {
        List<Colunmn> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn c,user_col uc where c.colId=uc.colId AND uc.userName=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Colunmn colunmn = new Colunmn(
                        rs.getInt("colId"),
                        rs.getString("colName")
                );
                list.add(colunmn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return list;
    }


    /**
     * 发布新闻
     *
     * @param title    标题
     * @param colName  栏目
     * @param content  内容
     * @param userName 发布人
     */
    @Override
    public void postNew(String title, String colName, String content, String userName) {
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
            ps.setObject(1, newsId);
            ps.setObject(2, title);
            ps.setObject(3, content);
            ps.setObject(4, postTime);
            ps.setObject(5, userName);
            ps.executeUpdate();
            if (ps != null)
                ps.close();
            // 再将新闻绑定发布的栏目
            // 获取栏目id
            Integer colId = colunmnDao.getColIdByColName(colName);
            String sql1 = "insert into new_col(newId,colId) values (?,?)";
            ps1 = con.prepareStatement(sql1);
            ps1.setObject(1, newsId);
            ps1.setObject(2, colId);
            ps1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps1);
        }
    }

    /**
     *  根据登录账户获取权限以内新闻总数
     *
     * @param username
     * @return
     */
    @Override
    public Integer getWithinNewsCount(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = 0;
        try {
            // 获取登录人负责的栏目
            List<Colunmn> colunmns = getRespColunmn(username);
            // 获取栏目下的新闻
            con = DBUtil.getCon();
            String sql = "select COUNT(news.newId) count from news ,new_col nc,colunmn c \n" +
                    "where news.newId = nc.newId  AND  c.colId=nc.colId  AND nc.colId = ?";
            ps = con.prepareStatement(sql);
            rs = null;
            // 循环填充占位符
            for (int i = 0; i < colunmns.size(); i++) {
                ps.setObject(1, colunmns.get(i).getColid());
                rs = ps.executeQuery();
                // 获取对应栏目下的新闻
                if (rs.next()) {
                    count += rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return count;
    }

    /**
     * 根据用户获取账户负责的新闻发布历史
     *
     * @param username
     * @return
     */
    @Override
    public List<News> getWithinNewsByUserName(String username) {
        List<News> newsList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取登录人负责的栏目
            List<Colunmn> colunmns = getRespColunmn(username);
            // 获取栏目下的新闻
            con = DBUtil.getCon();
            String sql = "select * from news ,new_col nc,colunmn c " +
                    "where news.newId = nc.newId  AND  c.colId=nc.colId  AND nc.colId=?";
            ps = con.prepareStatement(sql);
            rs = null;
            // 循环填充占位符
            for (int i = 0; i < colunmns.size(); i++) {
                ps.setObject(1, colunmns.get(i).getColid());
                rs = ps.executeQuery();
                // 获取对应栏目下的新闻
                while (rs.next()) {
                    News news = new News(
                            rs.getInt("newId"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getDate("postTime"),
                            colunmns.get(i)
                    );
                    newsList.add(news);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return newsList;
    }


    /**
     *  修改新闻发布到的栏目
     *
     * @param newId   新闻id
     * @param colName 栏目
     */
    @Override
    public void EditNew(Integer newId, String colName,String title) {
        // 根据栏目名称获取栏目id
        Integer colId = colunmnDao.getColIdByColName(colName);
        Connection con = DBUtil.getCon();
        String sql = "update new_col set colId=? where newId=?";
        String sql1 = "update news set title=? where newId=?";
        PreparedStatement ps = null;
        try {
            // 修改新闻栏目
            ps = con.prepareStatement(sql);
            ps.setObject(1,colId);
            ps.setObject(2,newId);
            ps.executeUpdate();
            // 修改新闻标题
            ps = con.prepareStatement(sql1);
            ps.setObject(1,title);
            ps.setObject(2,newId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }

    }

    /**
     *  通过新闻id获取到新闻标题
     *
     * @param newId
     * @return
     */
    @Override
    public String getTitleByNewId(Integer newId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from news where newId=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,newId);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }

    /**
     *  获取栏目下所有新闻
     *
     * @param colName 栏目名
     * @return
     */
    @Override
    public List<News> getAllNewsByColName(String colName) {
        List<News> newsList = new ArrayList<>();
        Connection con = DBUtil.getCon();
        String sql = "SELECT * from colunmn c,new_col nc,news n where c.colId = nc.colId and nc.newId=n.newId and c.colName=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1,colName);
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News(
                        rs.getInt("newId"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("postTime"),
                        new Colunmn(colName)
                );
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        DBUtil.closeAll(con,ps,rs);
        return newsList;
    }

    /**
     *  获取栏目下标题名包含title的新闻
     *
     * @param colName 栏目名
     * @param title   标题
     * @return
     */
    @Override
    public List<News> getAllNewsByCollNameAndTitle(String colName, String title) {
        List<News> newsList = new ArrayList<>();
        Connection con = DBUtil.getCon();
        String sql = "SELECT * from colunmn c,new_col nc,news n where c.colId = nc.colId and nc.newId=n.newId and c.colName=? AND n.title LIKE ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1,colName);
            ps.setObject(2,"%"+title+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                News news = new News(
                        rs.getInt("newId"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("postTime"),
                        new Colunmn(colName)
                );
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        DBUtil.closeAll(con,ps,rs);
        return newsList;
    }


}
