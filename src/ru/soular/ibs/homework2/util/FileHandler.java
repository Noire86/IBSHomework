package ru.soular.ibs.homework2.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileHandler {

    public static List<String> parseFile(Path file) throws IOException {
        String whole = String.join(":", Files.readAllLines(file));
        List<String> result = new ArrayList<>(Arrays.asList(whole.toLowerCase().split("[^\\da-zA-Zа-яёА-ЯЁ]+")));
        result.sort(String::compareToIgnoreCase);
        return result;
    }

    public static List<String> parseFile(Path file, boolean unique) throws IOException {
        if (unique) {
            List<String> list = new ArrayList<>(new HashSet<>(parseFile(file)));
            list.sort(String::compareToIgnoreCase);
            return list;
        }
        return parseFile(file);
    }

    public static Path getFile(String filePath) {
        Path path = Paths.get(filePath);
        return path.toAbsolutePath();
    }
}


