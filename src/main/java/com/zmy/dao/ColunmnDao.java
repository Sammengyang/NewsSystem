package com.zmy.dao;

import com.zmy.pojo.Colunmn;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 15:00
 */
public interface ColunmnDao {

    /**
     *  获取所有栏目编号和名字
     *
     * @return
     */
    List<Colunmn> getColList();

    /**
     *  根据用户名获取对应的栏目权限
     *
     * @param username 用户名
     * @return
     */
    List<Colunmn> getColListByuserName(String username);
}
