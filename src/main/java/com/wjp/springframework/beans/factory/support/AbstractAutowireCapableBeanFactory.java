package com.wjp.springframework.beans.factory.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.PropertyValue;
import com.wjp.springframework.beans.factory.config.BeanDefinition;
import com.wjp.springframework.beans.factory.config.BeanReference;
import com.wjp.springframework.util.BeanUtil;

import java.lang.reflect.Constructor;
import java.util.List;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
//            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
            bean = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("创建bean错误");
        }
        applyPropertyValues(bean, beanDefinition);
        addSingleton(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) {
        try {
            List<PropertyValue> propertyValueList = beanDefinition.getPropertyValues().getPropertyValueList();
            for (PropertyValue pv : propertyValueList) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);

            }
        } catch (Exception e) {
            throw new BeansException("填充bean属性失败" + bean);
        }
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        Constructor<?> constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : constructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }

        try {
            bean = instantiationStrategy.instantiate(beanDefinition, beanName, constructor, args);
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }

        return bean;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
