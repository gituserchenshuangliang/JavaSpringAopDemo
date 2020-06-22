package com.aop.service;

import com.aop.entity.Role;
import com.util.LoggerUtil;
import org.springframework.stereotype.Component;

/**
 * description:当有接口时使用JDK动态代理，没有接口时使用CGLIB动态代理
 * @author: Cherry
 * @time: 2020/6/7 9:47
 */
public class Roleservice2 {

    public void attack(Role role){
        LoggerUtil.getLog(Roleservice2.class).info("RoleService2"+role.getName()+"发起"+role.getNote());
    }
}
