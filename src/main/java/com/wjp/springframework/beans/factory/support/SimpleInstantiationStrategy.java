package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * JDK 实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName,
                              Constructor constructor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            if (constructor != null) {
                bean = beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                bean = beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BeansException("JDK反射创建有参bean对象失败");
        }

        return bean;
    }
}
