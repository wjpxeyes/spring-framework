package com.wjp.springframework.context.support;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wjp.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.wjp.springframework.beans.factory.config.BeanPostProcessor;
import com.wjp.springframework.context.ConfigurableApplicationContext;
import com.wjp.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        // 1.创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();
        // 2.获取bean工厂
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3.在 Bean 实例化之前，执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        registerBeanPostProcessors(beanFactory);
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        return beanFactory.getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        Object bean = beanFactory.getBean(name, args);
        return bean;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
