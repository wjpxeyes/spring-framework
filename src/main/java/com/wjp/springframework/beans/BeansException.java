package com.wjp.springframework.beans;

public class BeansException extends Throwable {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
