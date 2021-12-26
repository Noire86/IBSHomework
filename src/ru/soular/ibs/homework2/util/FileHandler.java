package ru.soular.ibs.homework2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    public static List<String> parseFile(File file) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (bufferedReader.ready()){
            String[] splitArray = bufferedReader.readLine().split("\\W+");
            list.addAll(Arrays.asList(splitArray));
        }

        return list;
    }
}
