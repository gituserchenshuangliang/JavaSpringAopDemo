package com.aop.config;

import com.aop.aspect.RoleAspect;
import com.aop.entity.Role;
import com.aop.service.Roleservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/7 10:00
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {Role.class, Roleservice.class, RoleAspect.class})
public class AppConfig {
    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }
}
