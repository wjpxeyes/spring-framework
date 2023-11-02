package com.wjp.springframework.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
