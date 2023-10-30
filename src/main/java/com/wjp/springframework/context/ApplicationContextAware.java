package com.wjp.springframework.context;

import com.wjp.springframework.beans.BeansException;
import com.wjp.springframework.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
