package com.zmy.service.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.Impl.NewsDaoImpl;
import com.zmy.dao.NewsDao;
import com.zmy.pojo.Colunmn;
import com.zmy.pojo.News;
import com.zmy.service.ColunmnService;
import com.zmy.service.NewsService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-22 21:54
 */
public class NewsServiceImpl implements NewsService {

    private final ColunmnService colunmnService = new ColunmnServiceImpl();
    private final NewsDao newsDao = new NewsDaoImpl();

    /**
     *  获取登录人负责的栏目
     *
     * @return
     */
    @Override
    public List<Colunmn> getRespColunmn(String username) {
        return newsDao.getRespColunmn(username);
    }

//    @Override
//    public List<News> getAllNews() {
//        return null;
//    }


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
        newsDao.postNew(title,colName,content,userName);
    }

    /**
     *  根据登录账户获取权限以内新闻总数
     *
     * @param username
     * @return
     */
    @Override
    public Integer getWithinNewsCount(String username) {
        return newsDao.getWithinNewsCount(username);
    }

    /**
     *  根据用户获取账户负责的新闻发布历史
     *
     * @param username
     * @return
     */
    @Override
    public List<News> getWithinNewsByUserName(String username) {
        return newsDao.getWithinNewsByUserName(username);
    }

    /**
     *  根据用户获取账户负责的新闻发布历史  分页查询
     *
     * @param username   账户用户名
     * @param pageNum    页数
     * @param pageSize   每页条数
     * @return
     */
//    @Override
//    public List<News> getWithinNewsByUserName(String username, Integer pageNum, Integer pageSize) {
//        return newsDao.getWithinNewsByUserName(username,pageNum,pageSize);
//    }

    /**
     *  修改新闻发布到的栏目
     *
     * @param newId   新闻id
     * @param colName 栏目
     */
    @Override
    public void EditNew(Integer newId, String colName ,String title) {
        newsDao.EditNew(newId,colName,title);
    }

    /**
     *  通过新闻id获取到新闻标题
     *
     * @param newId
     * @return
     */
    @Override
    public String getTitleByNewId(Integer newId) {
        return newsDao.getTitleByNewId(newId);
    }

    /**
     *  获取栏目下所有新闻
     *
     * @param colName 栏目名
     * @return
     */
    @Override
    public List<News> getAllNewsByColName(String colName) {
        return newsDao.getAllNewsByColName(colName);
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
        return newsDao.getAllNewsByCollNameAndTitle(colName,title);
    }

}
