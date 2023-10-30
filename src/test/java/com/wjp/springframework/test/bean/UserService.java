package com.wjp.springframework.test.bean;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.BeanClassLoaderAware;
import com.wjp.springframework.beans.factory.BeanFactory;
import com.wjp.springframework.beans.factory.BeanFactoryAware;
import com.wjp.springframework.beans.factory.BeanNameAware;
import com.wjp.springframework.context.ApplicationContext;
import com.wjp.springframework.context.ApplicationContextAware;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }
}
