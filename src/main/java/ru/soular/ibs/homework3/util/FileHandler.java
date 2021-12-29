package ru.soular.ibs.homework3.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    public static Path getFile(String filePath) {
        return Paths.get(filePath).toAbsolutePath();
    }
}
