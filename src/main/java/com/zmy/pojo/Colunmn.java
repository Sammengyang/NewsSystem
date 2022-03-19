package com.zmy.pojo;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 22:01
 */
public class Colunmn {
    private Integer colid; // 栏目id
    private String ColName; // 栏目名称

    public Colunmn() {
    }

    public Colunmn(Integer colid, String colName) {
        this.colid = colid;
        ColName = colName;
    }

    public Integer getColid() {
        return colid;
    }

    public void setColid(Integer colid) {
        this.colid = colid;
    }

    public String getColName() {
        return ColName;
    }

    public void setColName(String colName) {
        ColName = colName;
    }
}
