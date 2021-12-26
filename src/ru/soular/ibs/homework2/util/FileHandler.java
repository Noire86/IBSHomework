package ru.soular.ibs.homework2.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileHandler {

    public static List<String> parseFile(Path file) throws IOException {
        List<String> list = Files.readAllLines(file);
        List<String> result = new ArrayList<>();

        for (String s : list) {
            result.addAll(Arrays.asList(s.toLowerCase().split("[^a-zA-Zа-яёА-ЯЁ]+")));
        }

        result.sort(String::compareToIgnoreCase);


        return result;
    }

    public static List<String> parseFile(Path file, boolean unique) throws IOException {
        if (unique) {
            Set<String> set = new HashSet<>(parseFile(file));
            List<String> list = new ArrayList<>(set);
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


