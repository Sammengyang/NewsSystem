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
        newsDao.postNew(title,colName,content,userName);
    }


}
