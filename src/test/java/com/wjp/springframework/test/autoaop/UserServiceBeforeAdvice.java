package com.wjp.springframework.test.autoaop;

import com.wjp.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我是前置拦截方法：" + method.getName());
    }
}
