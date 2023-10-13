package com.wjp.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource {
    private final File file;
    private final String path;

    public String getPath() {
        return path;
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }


    @Override
    public InputStream getInputStream() throws IOException {
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        return new FileInputStream(file);
    }
}
