package ru.soular.ibs.homework3.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.soular.ibs.homework3.classes.Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonHandler {
    private static final Gson gson = new GsonBuilder().create();

    static class SerializableModel {
        public List<Company> companies;

        public List<Company> getCompanies() {
            return companies;
        }
    }

    public static <T> String serialize(T obj){
       return gson.toJson(obj);
    }

    public static List<Company> deserialize(String s){
        SerializableModel model = gson.fromJson(s, SerializableModel.class);
        return model.getCompanies();
    }


    public static String getJSON(Path path) throws IOException {
        return String.join("", Files.readAllLines(path)).trim();
    }


}
