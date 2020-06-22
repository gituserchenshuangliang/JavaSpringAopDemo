package com.jkdproxy.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/7 8:50
 */
public interface DbInter {
    Connection getConnection();
    void update(String sql,String[] param) throws SQLException;
}
