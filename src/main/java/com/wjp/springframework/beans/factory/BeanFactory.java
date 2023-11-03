package com.wjp.springframework.beans.factory;

import com.wjp.springframework.beans.BeansException;

/**
 * 由最初的类，改为接口，将实现交给子类
 */
public interface BeanFactory {
    /**
     * 获取bean对象
     *
     * @param name bean对象的名字
     * @return bean对象
     */
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
