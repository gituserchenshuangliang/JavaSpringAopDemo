package com.aop.service;

import com.aop.entity.Role;

public class AddInterImpl implements AddInter{
    @Override
    public void showRole(Role role) {
        System.out.println(role);
    }
}
