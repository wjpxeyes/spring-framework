package com.wjp.springframework;

public class BeanDefinition {
    /**
     * 存放bean的对象
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "bean=" + bean +
                '}';
    }
}
