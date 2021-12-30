package ru.soular.ibs.homework3;

import ru.soular.ibs.homework3.classes.Company;
import ru.soular.ibs.homework3.util.FileHandler;
import ru.soular.ibs.homework3.util.JsonHandler;
import ru.soular.ibs.homework3.util.MenuHandler;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        try{
        List<Company> list = JsonHandler.deserialize(JsonHandler.getJSON(FileHandler.getFile("shares.json")));

            MenuHandler.printShares(list.get(0));
            MenuHandler.printCompany(list.get(0));
            MenuHandler.printDelimiter();
            MenuHandler.printShares(list, "RUB");

            MenuHandler.printDelimiter();
            MenuHandler.printShares("10.12.2600", list);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
