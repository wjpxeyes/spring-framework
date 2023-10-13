package com.wjp.springframework.test.bean.com.wjp.springframework.test;

import com.wjp.springframework.BeanDefinition;
import com.wjp.springframework.BeanFactory;
import com.wjp.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {
    @Test
    void testBeanFactory() {
        UserService service = new UserService("sdsa", 13, 669L);
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(service);
        beanFactory.registerBeanDefinition("111", beanDefinition);
        Object bean = beanFactory.getBean("111");
        System.out.println(bean);
    }
}
