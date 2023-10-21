package com.wjp.springframework.beans.factory;

public interface DisposableBean {
    void destroy() throws Exception;
}
