package com.treasure.common.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author: mazy
 * @date: 2018/9/18 16:33
 */
public class FileUtils {
    /**
     * 把文件写入target
     * @param bytes 要写入文件的内容
     * @param target 目标文件，会自动创建父目录
     * @return 写入文件后的Path
     * @throws Exception
     */
    public static final Path write(byte[] bytes, Path target) throws IOException {
        // 创建目录
        createDirectories(target);
        target = Files.write(target, bytes);
        return target;
    }

    /**
     * 如果文件父级目录不存在的话，创建所有父级目录
     * @param path
     * @throws IOException
     */
    public static final void createDirectories(Path path) throws IOException {
        boolean exists = Files.exists(path);
        if (!exists) {
            Files.createDirectories(path.getParent());
        }
    }
}
