package com.wjp.springframework.beans.factory;

import com.wjp.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.wjp.springframework.beans.factory.config.BeanDefinition;
import com.wjp.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, AutowireCapableBeanFactory, ListableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName);

}
