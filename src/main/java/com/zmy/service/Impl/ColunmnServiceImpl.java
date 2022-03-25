package com.zmy.service.Impl;

import com.zmy.dao.ColunmnDao;
import com.zmy.dao.Impl.ColunmnDaoImpl;
import com.zmy.pojo.Colunmn;
import com.zmy.service.ColunmnService;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-22 17:45
 */
public class ColunmnServiceImpl implements ColunmnService {

    private final ColunmnDao colunmnDao = new ColunmnDaoImpl();

    /**
     *  校验栏目名是否可用
     *
     * @param colName  栏目名
     * @return
     */
    @Override
    public boolean CheckColName(String colName) {
        return colunmnDao.CheckColName(colName);
    }

    /**
     *  校验栏目编号是否可用
     *
     * @param colId  栏目编号
     * @return
     */
    @Override
    public boolean CheckColCid(Integer colId) {
        return colunmnDao.CheckColCid(colId);
    }

    /**
     *  获取栏目总数
     *
     * @return
     */
    @Override
    public Integer getColunmnCount() {
        return colunmnDao.getColunmnCount();
    }

    /**
     *  获取所有栏目
     *
     * @return
     */
    @Override
    public List<Colunmn> getAllColunmn() {
        return colunmnDao.getColList();
    }

    /**
     *  分页查询栏目
     *
     * @param pageNum   页数
     * @param pageSize  每页的个数
     * @return
     */
    @Override
    public List<Colunmn> getAllColunmnByPage(Integer pageNum, Integer pageSize) {
        return colunmnDao.getAllColunmnByPage(pageNum,pageSize);
    }

    /**
     *  添加栏目
     *
     * @param colId   栏目id
     * @param colName 栏目名称
     */
    @Override
    public int addColunmn(Integer colId, String colName) {
        return colunmnDao.addColunmn(colId,colName);
    }

    /**
     *  根据栏目id删除栏目
     *
     * @param colId 栏目id
     * @return
     */
    @Override
    public int delColunmn(Integer colId) {
        return colunmnDao.delColunmn(colId);
    }

    @Override
    public int editColunmn(Integer colId, Integer editId, String editName) {
        return colunmnDao.editColunmn(colId,editId,editName);
    }

    @Override
    public List<Colunmn> SerchColunmnByColName(String colName) {
        return colunmnDao.SerchColunmnByColName(colName);
    }
}
