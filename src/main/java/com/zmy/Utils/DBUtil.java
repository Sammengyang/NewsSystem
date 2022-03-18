package com.zmy.Utils;

import java.sql.*;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-11 20:10
 */
public class DBUtil {
    static String url = "jdbc:mysql://localhost:3306/java39?rewriteBatchedStatements=true&useSSL=false";
    static String user = "root";
    static String password = "123456";
    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getCon(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭流
     *
     * @param con  驱动连接
     * @param ps   预处理
     */
    public static void closeAll(Connection con,PreparedStatement ps){
        try {
            if (con!=null)
                con.close();
            if (ps!=null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关流
     *
     * @param con 驱动连接
     * @param ps  预编译
     * @param rs  结果集
     */
    public static void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
        try {
            if (con!=null)
                con.close();
            if (ps!=null)
                ps.close();
            if (rs!=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
