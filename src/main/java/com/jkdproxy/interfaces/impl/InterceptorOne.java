package com.jkdproxy.interfaces.impl;

import com.jkdproxy.interfaces.Interceptor;
import com.util.LoggerUtil;
import org.apache.logging.log4j.Logger;

/**
 * @description:拦截器的一个实现类
 * @author: Cherry
 * @time: 2020/6/7 7:50
 */
public class InterceptorOne implements Interceptor {
    Logger logger = LoggerUtil.getLog(InterceptorOne.class);
    @Override
    public void before(Object obj) {
        logger.info("调用方法之前");
    }

    @Override
    public void after(Object obj) {
        logger.info("调用方法之后");
    }

    @Override
    public void afterReturning(Object obj) {
        logger.info("finally执行");
    }

    @Override
    public void afterThrowing(Object obj) {
        logger.info("抛出异常之后");
    }
}
