package com.wjp.springframework.test.bean.com.wjp.springframework.test;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.config.BeanDefinition;
import com.wjp.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wjp.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {


//    第一次的测试代码
//    @Test
//    void testBeanFactory() {
//        UserService service = new UserService("sdsa", 13, 669L);
//        BeanFactory beanFactory = new BeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(service);
//        beanFactory.registerBeanDefinition("111", beanDefinition);
//        Object bean = beanFactory.getBean("111");
//        System.out.println(bean);
//    }

    @Test
    void testBeanFactory() throws BeansException {
        // 1.创建bean工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 2.创建beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        // 3.添加bean到bean工厂
        factory.registryBeanDefinition("user", beanDefinition);
        // 4。第一次获取bean
        UserService user = (UserService) factory.getBean("user");
        System.out.println(user);
        user.test();

        // 5.第二次获取bean
        UserService user1 = (UserService) factory.getBean("user");
        System.out.println(user1);
        user1.test();


    }
}
