package com.zmy.service;

import com.zmy.pojo.Colunmn;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-22 17:44
 */
public interface ColunmnService {

    /**
     *  获取栏目总数
     *
     * @return
     */
    Integer getColunmnCount();

    /**
     *  获取所有栏目
     *
     * @return
     */
    List<Colunmn> getAllColunmn();

    /**
     *  分页查询栏目
     *
     * @param pageNum   页数
     * @param pageSize  每页的个数
     * @return
     */
    List<Colunmn> getAllColunmnByPage(Integer pageNum,Integer pageSize);

    /**
     *  添加栏目
     *
     * @param colId   栏目id
     * @param colName 栏目名称
     */
    int addColunmn(Integer colId,String colName);

    /**
     *  根据栏目id删除栏目
     *
     * @param colId 栏目id
     * @return
     */
    int delColunmn(Integer colId);

    /**
     *  根据id修改栏目信息
     *
     * @param colId    原栏目id
     * @param editId   修改的id
     * @param editName 修改的名字
     * @return
     */
    int editColunmn(Integer colId,Integer editId,String editName);

    /**
     *  通过栏目名称查询栏目  （模糊查询）
     *
     * @param colName
     * @return
     */
    List<Colunmn> SerchColunmnByColName(String colName);
}
