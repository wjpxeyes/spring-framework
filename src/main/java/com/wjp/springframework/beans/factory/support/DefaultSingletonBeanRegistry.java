package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final HashMap<String, Object> singletonObjects = new HashMap<>(256);

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
