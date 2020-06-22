package com.aop.aspect;

import com.aop.entity.Role;
import com.util.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * description:使用XML文件配置Aspectj
 * @author: Cherry
 * @time: 2020/6/7 9:51
 */
public class RoleAspect2 {
    Logger logger =  LoggerUtil.getLog(RoleAspect2.class);

    //参数同时传递过来
    public void before(Role role) {
        logger.info("before2 ...."+role.getName());
    }

    public void after() {
        logger.info("after2 ....");
    }

    public void afterReturning() {
        logger.info("afterReturning2 ....");
    }

    public void afterThrowing() {
        logger.info("afterThrowing2 ....");
    }

    /**
     * @param joinPoint 它保留了调度被代理对象原有方法的功能，所以它强大又灵活。
     */
    public  void around(ProceedingJoinPoint joinPoint){
        logger.info("around before2......");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("around after2......");
    }
}
