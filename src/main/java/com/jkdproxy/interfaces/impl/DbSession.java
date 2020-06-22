package com.jkdproxy.interfaces.impl;

import com.jkdproxy.interfaces.DbInter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/7 8:39
 */
public class DbSession implements DbInter {
    @Override
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chen?serverTimezone=UTC&&useSSL=false","chen","chen");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public void update(String sql,String[] param) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement(sql);
        for (int i = 0; i < param.length;i++) {
         ps.setString(i+1,param[i]);
        }
        ps.executeUpdate();
    }
}
