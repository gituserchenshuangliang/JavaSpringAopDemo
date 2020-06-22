package com.aop.aspect;

import com.aop.entity.Role;
import com.util.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author: Cherry
 * @time: 2020/6/7 9:51
 */
@Aspect
public class RoleAspect {
    Logger logger =  LoggerUtil.getLog(RoleAspect.class);

    //切入点设置
    @Pointcut("execution(* com.aop.service.Roleservice.attack(..))")
    public void attack() {
    }

    //参数同时传递过来
    @Before("execution(* com.aop.service.Roleservice.attack(..))"+"&& args(role)")
    public void before(Role role) {
        logger.info("before ...."+role.getName());
    }

    @After("attack()")
    public void after() {
        logger.info("after ....");
    }

    @AfterReturning("attack()")
    public void afterReturning() {
        logger.info("afterReturning ....");
    }

    @AfterThrowing("attack()")
    public void afterThrowing() {
        logger.info("afterThrowing ....");
    }

    /**
     * @param joinPoint 它保留了调度被代理对象原有方法的功能，所以它强大又灵活。
     */
    @Around("attack()")
    public  void around(ProceedingJoinPoint joinPoint){
        logger.info("around before......");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("around after......");
    }
}
