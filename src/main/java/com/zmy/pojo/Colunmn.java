package com.zmy.pojo;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 22:01
 */
public class Colunmn {
    private Integer colid; // 栏目id
    private String colName; // 栏目名称

    public Colunmn() {
    }

    public Colunmn(Integer colid, String colName) {
        this.colid = colid;
        this.colName = colName;
    }

    public Colunmn(String colName) {
        this.colName = colName;
    }

    public Integer getColid() {
        return colid;
    }

    public void setColid(Integer colid) {
        this.colid = colid;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    @Override
    public String toString() {
        return "Colunmn{" +
                "colid=" + colid +
                ", colName='" + colName + '\'' +
                '}';
    }
}
