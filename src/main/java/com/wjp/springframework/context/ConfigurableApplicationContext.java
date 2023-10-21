package com.wjp.springframework.context;

import com.wjp.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     * @throws IllegalStateException
     */
    void refresh() throws BeansException, IllegalStateException;
}
