package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
    
}
