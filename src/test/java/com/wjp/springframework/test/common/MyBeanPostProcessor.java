package com.wjp.springframework.test.common;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.config.BeanPostProcessor;
import com.wjp.springframework.test.bean.UserService;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
