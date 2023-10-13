package com.wjp.springframework.test;

import com.wjp.springframework.beans.PropertyValue;
import com.wjp.springframework.beans.PropertyValues;
import com.wjp.springframework.beans.factory.config.BeanDefinition;
import com.wjp.springframework.beans.factory.config.BeanReference;
import com.wjp.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wjp.springframework.test.bean.UserDao;
import com.wjp.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

public class ApiTest {
//    第四次测试的代码

    @Test
    void testBeanFactory() {
        // 1.创建bean工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 2. 注入bean
        // 2.1 userdao注册
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", 13));
        propertyValues.addPropertyValue(new PropertyValue("name", "王景鹏"));
        factory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class, propertyValues));
        // 2.2 userService注册
        PropertyValues values = new PropertyValues();
        values.addPropertyValue(new PropertyValue("name", "王景鹏1111"));
        values.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        factory.registryBeanDefinition("userService", new BeanDefinition(UserService.class, values));
        // 3.获取bean
        Object userDao = factory.getBean("userDao");
        System.out.println(userDao);
        UserService userService = (UserService) factory.getBean("userService");
        System.out.println(userService);
        userService.test();
    }


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

//    第二次测试的代码
    //    @Test
//    void testBeanFactory() throws BeansException {
//        // 1.创建bean工厂
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        // 2.创建beanDefinition
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        // 3.添加bean到bean工厂
//        factory.registryBeanDefinition("user", beanDefinition);
//        // 4。第一次获取bean
//        UserService user = (UserService) factory.getBean("user");
//        System.out.println(user);
//        user.test();
//
//        // 5.第二次获取bean
//        UserService user1 = (UserService) factory.getBean("user");
//        System.out.println(user1);
//        user1.test();
//    }

//    第三次测试的代码
//    @Test
//    public void test_BeanFactory() throws BeansException {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
//        // 2. 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registryBeanDefinition("userService", beanDefinition);
//
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService", "孙卫国");
//        userService.test();
//        System.out.println(userService);
//    }
}
