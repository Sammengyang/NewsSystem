package com.zmy.pojo;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-18 21:10
 */
public class Account {
    private String userName; // 用户名
    private String Name; // 姓名
    private String password; // 密码
    private String tel;      // 手机号
    private List<Colunmn> colunmns; // 能查看和发布的栏目
    private String role;     // 权限

    public Account() {
    }


    public Account(String userName, String name, String password, String tel, List<Colunmn> colunmns, String role) {
        this.userName = userName;
        Name = name;
        this.password = password;
        this.tel = tel;
        this.colunmns = colunmns;
        this.role = role;
    }

    public Account(String username,String password, String tel, String role) {
        this.userName = username;
        this.tel = tel;
        this.password = password;
        this.role = role;
    }

    public Account(String userName, String name, String password, String tel, String role) {
        this.userName = userName;
        this.Name = name;
        this.password = password;
        this.tel = tel;
        this.role = role;
    }

    public Account(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Colunmn> getColunmns() {
        return colunmns;
    }

    public void setColunmns(List<Colunmn> colunmns) {
        this.colunmns = colunmns;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", colunmns=" + colunmns +
                ", role='" + role + '\'' +
                '}';
    }
}
