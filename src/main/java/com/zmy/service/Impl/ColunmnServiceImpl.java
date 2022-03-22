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
     *  获取所有栏目
     *
     * @return
     */
    @Override
    public List<Colunmn> getAllColunmn() {
        return colunmnDao.getColList();
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
