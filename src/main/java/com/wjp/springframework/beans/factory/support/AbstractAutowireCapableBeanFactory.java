package com.wjp.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.PropertyValue;
import com.wjp.springframework.beans.factory.DisposableBean;
import com.wjp.springframework.beans.factory.InitializingBean;
import com.wjp.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.wjp.springframework.beans.factory.config.BeanDefinition;
import com.wjp.springframework.beans.factory.config.BeanPostProcessor;
import com.wjp.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
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
        bean = initializeBean(beanName, bean, beanDefinition);

        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
        addSingleton(beanName, bean);
        return bean;
    }

    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
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

    public Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException(e.getMessage());
        }
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现接口 InitializingBean
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }

        // 2. 注解配置 init-method {判断是为了避免二次执行初始化}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }
}
