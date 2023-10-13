package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final HashMap<String, BeanDefinition> beanDefinitionMap = new HashMap<>(256);

    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("没有这个名字的beanDefinition");
        }
        return beanDefinition;
    }
}
