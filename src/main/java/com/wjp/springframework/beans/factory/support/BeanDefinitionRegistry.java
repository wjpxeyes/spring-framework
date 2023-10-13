package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否有名为beanName的BeanDefinition
     *
     * @param beanName bean的名字
     * @return true表示有这个名字的BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取所有BeanDefinition的名字
     *
     * @return 所有BeanDefinition的名字
     */
    String[] getBeanDefinitionNames();


}
