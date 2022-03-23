package com.zmy.service;

import com.zmy.pojo.Colunmn;
import com.zmy.pojo.News;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-22 21:53
 */
public interface NewsService {



    /**
     *  获取登录人负责的新闻栏目
     *
     * @return
     */
    List<Colunmn> getRespColunmn(String username);

    /**
     *  获取所有新闻
     *
     * @return
     */
    List<News> getAllNews();

    /**
     *  发布新闻
     *
     * @param title     标题
     * @param colName   栏目
     * @param userName  发布人
     */
    void postNew(String title,String colName,String content,String userName);
}
