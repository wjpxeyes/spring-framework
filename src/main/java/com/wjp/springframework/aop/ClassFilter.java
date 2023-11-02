package com.wjp.springframework.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
