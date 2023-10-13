package com.wjp.springframework.util;

/**
 * 类的工具类
 */
public class ClassUtils {
    private ClassUtils() {
    }

    /**
     * 获取当前线程的类加载器
     *
     * @return 类加载器
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            throw new RuntimeException("类加载器为空");
        }
        return classLoader;
    }

}
