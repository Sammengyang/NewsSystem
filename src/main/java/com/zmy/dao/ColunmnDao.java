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
     *  校验栏目名是否可用
     *
     * @param colName  栏目名
     * @return
     */
    boolean CheckColName(String colName);

    /**
     *  校验栏目编号是否可用
     *
     * @param colId  栏目编号
     * @return
     */
    boolean CheckColCid(Integer colId);

    /**
     *  获取栏目总数
     *
     * @return
     */
    Integer getColunmnCount();

    /**
     *  获取所有栏目编号和名字
     *
     * @return
     */
    List<Colunmn> getColList();

    /**
     *  分页查询栏目
     *
     * @param pageNum   页数
     * @param pageSize  每页的个数
     * @return
     */
    List<Colunmn> getAllColunmnByPage(Integer pageNum,Integer pageSize);

    /**
     *  根据用户名获取对应的栏目权限
     *
     * @param username 用户名
     * @return
     */
    List<Colunmn> getColListByuserName(String username);

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

    /**
     *   根据栏目名字获取栏目id
     *
     * @param colName 栏目名称
     * @return
     */
    Integer getColIdByColName(String colName);
}
