package com.wjp.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源类接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
