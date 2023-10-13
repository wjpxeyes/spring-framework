package com.wjp.springframework.core.io;

import com.wjp.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类路径资源
 */
public class ClassPathResource implements Resource {
    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    public ClassPathResource(String path) {
        this(path, null);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new RuntimeException("类加载器获取类路径文件资源失败");
        }
        return is;
    }
}
