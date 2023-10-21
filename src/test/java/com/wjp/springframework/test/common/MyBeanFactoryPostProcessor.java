package com.wjp.springframework.test.common;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.PropertyValue;
import com.wjp.springframework.beans.PropertyValues;
import com.wjp.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wjp.springframework.beans.factory.config.BeanDefinition;
import com.wjp.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
