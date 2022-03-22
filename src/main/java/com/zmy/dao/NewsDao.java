package com.zmy.dao;

import com.zmy.pojo.News;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-22 22:02
 */
public interface NewsDao {

    /**
     *  产生一个随机新闻id
     *
     * @return
     */
    Integer RandomNewsId();

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
     * @param content   内容
     * @param userName  发布人
     */
    void postNew(String title,String colName,String content,String userName);
}
