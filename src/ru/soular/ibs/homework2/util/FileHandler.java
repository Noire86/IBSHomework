package ru.soular.ibs.homework2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<String> parseFile(File file) throws Exception {
        List<String> list = new ArrayList<>();
        String[] array;
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (bufferedReader.ready()){
        }


    }
}
