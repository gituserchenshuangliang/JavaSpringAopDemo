package com.jdkproxy;

import com.jkdproxy.DbProxy;
import com.jkdproxy.ProxyHello;
import com.jkdproxy.interfaces.DbInter;
import com.jkdproxy.interfaces.HelloInter;
import com.jkdproxy.interfaces.impl.DbSession;
import com.jkdproxy.interfaces.impl.DbTransaction;
import com.jkdproxy.interfaces.impl.HelloImpl;
import com.jkdproxy.interfaces.impl.InterceptorOne;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @description:动态代理拦截器测试
 * @author: Cherry
 * @time: 2020/6/7 7:57
 */
public class JdkProxy {
    @Test
    public void show(){
        //被代理目标
        HelloImpl hello = new HelloImpl();
        //拦截器
        InterceptorOne interceptorOne = new InterceptorOne();
        //代理类
        ProxyHello proxyHello = new ProxyHello();
        //被代理接口
        HelloInter inter = (HelloInter) proxyHello.getProxy(hello,interceptorOne);

        inter.say("心烦意乱");
    }

    @Test
    public void show2() throws SQLException {
        DbSession session = new DbSession();
        DbTransaction transaction = new DbTransaction();
        DbProxy dbProxy = new DbProxy();
        DbInter db = (DbInter) dbProxy.getProxy(session,transaction);
        String sql = "update role set role_name = ? where role_name = ?";
        String[] param = {"弓箭手","法师"};
        db.update(sql,param);
    }
}
