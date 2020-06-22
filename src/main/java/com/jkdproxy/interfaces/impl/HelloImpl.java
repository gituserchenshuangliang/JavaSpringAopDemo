package com.jkdproxy.interfaces.impl;

import com.jkdproxy.interfaces.HelloInter;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/7 7:34
 */
public class HelloImpl implements HelloInter {
    @Override
    public void say(String str) {
        System.out.println(str);
    }
}
