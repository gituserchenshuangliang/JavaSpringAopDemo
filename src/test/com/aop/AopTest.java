package com.aop;

import com.aop.config.AppConfig;
import com.aop.entity.Role;
import com.aop.service.AddInterImpl;
import com.aop.service.Roleservice;
import com.aop.service.Roleservice2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:面向切面测试
 * @author: Cherry
 * @time: 2020/6/7 10:02
 */
public class AopTest {
    @Test
    public void aspect(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
        Roleservice service = app.getBean(Roleservice.class);
        Role role = app.getBean(Role.class);
        service.attack(role);
    }

    @Test
    public void aspectXml(){
        ApplicationContext app = new ClassPathXmlApplicationContext("config/spring-config.xml");
        Roleservice service = app.getBean(Roleservice.class);
        Role role = app.getBean(Role.class);
        service.attack(role);
    }

    @Test
    public void aspectXml2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("config/spring-config.xml");
        Roleservice2 service = app.getBean(Roleservice2.class);
        Role role = app.getBean(Role.class);
        service.attack(role);
    }
}
