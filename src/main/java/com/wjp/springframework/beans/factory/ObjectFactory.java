package com.wjp.springframework.beans.factory;

import com.wjp.springframework.beans.BeansException;

public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
