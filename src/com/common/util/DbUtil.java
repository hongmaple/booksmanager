package com.common.util;

import java.sql.*;


/**
 * 数据库连接工具类
 */
public class DbUtil {
    //数据库连接地址 127.0.0.代表连接地址  3306 端口号   db代表数据库名称
    static String url = "jdbc:mysql://127.0.0.1:3306/bookmanage?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
    static String user = "root";
    static String pwd = "root";
    static String driver = "com.mysql.jdbc.Driver"; //mysql8.0以下版本
    //static String driver = "com.mysql.cj.jdbc.Driver"; //mysql8.0以上版本

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (null != resultSet) resultSet.close();
            if (null != statement) statement.close();
            if (null != connection) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        close(connection, null, null);
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }
}


