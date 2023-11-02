package com.wjp.springframework.context;

import java.util.EventListener;

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理事件
     *
     * @param event 要响应的事件
     */
    void onApplicationEvent(E event);

}
