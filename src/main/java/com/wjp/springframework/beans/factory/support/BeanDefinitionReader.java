package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.core.io.Resource;
import com.wjp.springframework.core.io.ResourceLoader;

/**
 * 读取 Spring 配置文件中的内容
 */
public interface BeanDefinitionReader {
    
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;


}
