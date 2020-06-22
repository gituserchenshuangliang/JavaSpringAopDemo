package com.jkdproxy.interfaces.impl;

import com.jkdproxy.interfaces.Interceptor;

import java.sql.SQLException;

/**
 * @description:数据库事务
 * @author: Cherry
 * @time: 2020/6/7 8:29
 */
public class DbTransaction implements Interceptor {
    @Override
    public void before(Object obj) {
    }

    @Override
    public void after(Object obj) throws SQLException {
        System.out.println("提交事务");
    }

    @Override
    public void afterReturning(Object obj) throws SQLException {
        System.out.println("关闭链接");
    }

    @Override
    public void afterThrowing(Object obj) throws SQLException {
        System.out.println("回滚事务");
    }
}
