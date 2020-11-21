package com.pi.util;

import java.sql.*;
import java.util.Properties;

public class DB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pisystem";
    static final String USER = "root";
    static final String PASS = "root";

    public static Connection createConn() {
        Connection con = null;
        Properties prop = new Properties();    //只要添加这几句话就可以
        prop.put("charSet", "gb2312");
        try {
            Class.forName(JDBC_DRIVER);


        } catch (ClassNotFoundException e) {
            System.out.println("" + e);
        }
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException el) {
        }
        return con;
    }

    public static PreparedStatement prepare(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public static void close(Connection conn) {

        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
            stmt = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
            rs = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
