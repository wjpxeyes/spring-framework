package com.wjp.springframework.beans.factory;

import com.wjp.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
