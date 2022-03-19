package com.zmy.dao.Impl;

import com.zmy.Utils.DBUtil;
import com.zmy.dao.ColunmnDao;
import com.zmy.pojo.Colunmn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 15:00
 */
public class ColunmnDaoImpl implements ColunmnDao {


    /**
     *  获取所有栏目编号和名字
     *
     * @return
     */
    @Override
    public List<Colunmn> getColList() {
        List<Colunmn> colunmnList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from colunmn";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Colunmn colunmn = new Colunmn(
                        rs.getInt("colId"),
                        rs.getString("ColName")
                );
                colunmnList.add(colunmn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return colunmnList;
    }
}
