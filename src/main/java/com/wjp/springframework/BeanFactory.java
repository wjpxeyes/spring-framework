package com.wjp.springframework;

import java.util.HashMap;

public class BeanFactory {
    private final HashMap<String, BeanDefinition> beanDefinitionHashMap = new HashMap<>();

    /**
     * TODO 目前有问题，会报空指针异常，以后再修复
     *
     * @param name bean对象的名字
     * @return bean对象
     */
    public Object getBean(String name) {
        return beanDefinitionHashMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionHashMap.put(name, beanDefinition);
    }
}
