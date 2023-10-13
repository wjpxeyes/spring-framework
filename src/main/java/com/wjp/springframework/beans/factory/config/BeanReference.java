package com.wjp.springframework.beans.factory.config;

public class BeanReference {
    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    private String beanName;

    public String getBeanName() {
        return beanName;
    }
}
