package com.jkdproxy.interfaces;

import java.sql.SQLException;

/**
 * @description:JDK动态代理拦截器
 * @author: Cherry
 * @time: 2020/6/7 7:31
 */
public interface Interceptor {
    void before(Object obj);
    void after(Object obj) throws SQLException;
    void afterReturning(Object obj) throws SQLException;
    void afterThrowing(Object obj) throws SQLException;
}
