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

    /**
     *  根据用户获取账户负责的新闻发布历史
     *
     * @param username
     * @return
     */
    List<News> getWithinNewsByUserName(String username);

    /**
     *  修改新闻发布到的栏目
     *
     * @param newId   新闻id
     * @param colName 栏目
     */
    void EditNew(Integer newId,String colName,String title);

    /**
     *  通过新闻id获取到新闻标题
     *
     * @param newId
     * @return
     */
    String getTitleByNewId(Integer newId);

    /**
     *  获取栏目下所有新闻
     *
     * @param colName 栏目名
     * @return
     */
    List<News> getAllNewsByColName(String colName);

    /**
     *  获取栏目下标题名包含title的新闻
     *
     * @param colName 栏目名
     * @param title   标题
     * @return
     */
    List<News> getAllNewsByCollNameAndTitle(String colName,String title);
}
