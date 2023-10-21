package com.wjp.springframework.beans.factory;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
