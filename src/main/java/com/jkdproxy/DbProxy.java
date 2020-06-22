package com.jkdproxy;

import com.jkdproxy.interfaces.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:数据库动态代理
 * @author: Cherry
 * @time: 2020/6/7 8:33
 */
public class DbProxy implements InvocationHandler {
    private Object target;
    private Interceptor interceptor;

    public Object getProxy(Object obj,Interceptor interceptor){
        this.target = obj;
        this.interceptor = interceptor;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retObj = null;
        //是否产生异常
        boolean exceptionFlag = false;
        //before方法
        interceptor.before(target);
        try {
            //反射原有方法
            retObj = method.invoke(target, args);
        } catch (Exception ex) {
            ex.printStackTrace();
            exceptionFlag = true;
        } finally {
            //after方法
            interceptor.after(target);
        }
        if (exceptionFlag) {
            //afterThrowing方法
            interceptor.afterThrowing(target);
        } else {
            //afterReturning方法
            interceptor.afterReturning(target);
        }
        return retObj;
    }
}
