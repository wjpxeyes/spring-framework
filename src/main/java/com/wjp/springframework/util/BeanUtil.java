package com.wjp.springframework.util;

import com.wjp.springframework.beans.BeansException;

import java.lang.reflect.Field;

public class BeanUtil {
    private BeanUtil() {
    }

    public static void setFieldValue(Object bean, String name, Object value) {
        Class<?> beanClass = bean.getClass();
        try {
            Field field = beanClass.getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean, value);

        } catch (Exception e) {
            throw new BeansException("使用工具类给字段" + name + "赋值失败");
        }
    }
}
