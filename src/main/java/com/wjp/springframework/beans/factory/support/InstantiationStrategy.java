package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    public Object instantiate(BeanDefinition beanDefinition, String beanName,
                              Constructor constructor, Object[] args) throws BeansException;

}
