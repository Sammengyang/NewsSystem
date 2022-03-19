package com.zmy.pojo;

import java.sql.Date;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-19 8:59
 */
public class News {
    private Integer NewId; // 新闻编号
    private String title; // 新闻标题
    private String content; // 新闻内容
    private List<Colunmn> colunmns; // 能发布到的栏目
    private Date postTime; // 发布时间
    private String Name; // 发布人

    public News() {
    }

    public News(Integer newId, String title, String content, List<Colunmn> colunmns, Date postTime, String name) {
        NewId = newId;
        this.title = title;
        this.content = content;
        this.colunmns = colunmns;
        this.postTime = postTime;
        Name = name;
    }


    public Integer getNewId() {
        return NewId;
    }

    public void setNewId(Integer newId) {
        NewId = newId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Colunmn> getColunmns() {
        return colunmns;
    }

    public void setColunmns(List<Colunmn> colunmns) {
        this.colunmns = colunmns;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
