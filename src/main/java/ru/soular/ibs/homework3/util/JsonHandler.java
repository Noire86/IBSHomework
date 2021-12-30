package ru.soular.ibs.homework3.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import ru.soular.ibs.homework3.classes.Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonHandler {
    private static final Gson gson = new GsonBuilder().create();

    static class SerializableModel {
        public List<Company> companies;

        public List<Company> getCompanies() {
            return companies;
        }
    }

    public static <T> String serialize(T obj) {
        return gson.toJson(obj);
    }

    public static List<Company> deserialize(String s) throws JsonSyntaxException {
        SerializableModel model = gson.fromJson(s, SerializableModel.class);
        return model.getCompanies();
    }

    public static List<String> getCurrencies(List<Company> companyList) throws NullPointerException {
        Set<String> set = new HashSet<>();
        companyList.forEach(c -> c.getSecurities().forEach(security -> set.addAll(Arrays.asList(security.getCurrency()))));
        return new ArrayList<>(set);
    }

    public static boolean checkCurrency(String currency, List<Company> companyList) {
        try {
             if (getCurrencies(companyList).stream().anyMatch(s -> s.equalsIgnoreCase(currency))) {
                 return true;
             } else {
                 System.out.println("Provided currency type is not used in the file!");
                 return false;
             }
        } catch (NullPointerException e) {
            System.out.println("Currencies were not found!");
            return false;
        }
    }

    public static String getJSON(Path path) throws IOException {
        return String.join("", Files.readAllLines(path)).trim();
    }


}
