package ru.soular.ibs.homework3.util;

import ru.soular.ibs.homework3.classes.Company;
import ru.soular.ibs.homework3.classes.Security;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MenuHandler {
    public static final String[] DATE_FORMAT = {"dd.MM.yyyy", "dd/MM/yyyy", "dd/MM/uu"};


    public static void printMenu() {

    }

    public static void printDelimiter() {
        System.out.println("============================");
    }

    public static void printCompany(Company c) {
        LocalDate founded = LocalDate.parse(c.getFounded(), DateTimeFormatter.ofPattern(DATE_FORMAT[0]));
        System.out.println(c.getName() + " - Was founded since: " + founded.format(DateTimeFormatter.ofPattern("dd.MM.yy")));
    }

    public static void printShares(Company c) {
        List<Security> expiredShares = c.getSecurities().stream()
                .filter(security -> LocalDate.now().isAfter(LocalDate.parse(security.getDate(), DateTimeFormatter.ofPattern(DATE_FORMAT[0]))))
                .collect(Collectors.toList());

        System.out.println("Expired shares of holder " + c.getName() + ":");
        for (Security s : expiredShares) {
            System.out.printf("Share: %s | Code: %s | Expiry: %s | Currency: %s|%n", s.getName(), s.getCode(), s.getDate(), Arrays.toString(s.getCurrency()));
        }
        System.out.println("Overall count of expired shares: " + expiredShares.size());
    }

    public static void printShares(List<Company> companiesList, String currency) {

        System.out.println("Shares by currency type: " + currency.toUpperCase());
        companiesList.stream()
                .flatMap(c -> c.getSecurities().stream())
                .filter(s -> Arrays.stream(s.getCurrency()).anyMatch(str -> str.equalsIgnoreCase(currency)))
                .map(s -> String.format("Share: %s Code: %s", s.getName(), s.getCode()))
                .distinct()
                .forEachOrdered(System.out::println);
    }

    public static void printShares(String date, List<Company> list) {
        LocalDate userDate = null;
        LocalDate foundedDate = null;
        boolean result = false;


        for (Company c : list) {

            for (String s : DATE_FORMAT) {

                try {
                    userDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(s));
                } catch (DateTimeException ignored) {
                }

                try {
                    foundedDate = LocalDate.parse(c.getFounded(), DateTimeFormatter.ofPattern(DATE_FORMAT[0]));
                } catch (DateTimeException ignored) {
                }

            }

            if (userDate != null && foundedDate != null) {
                result = foundedDate.isAfter(userDate);
            } else {
                System.out.println("Invalid date value!");
                break;
            }

            if (result) {
                printCompany(c);
            } else {
                System.out.println("None of the companies were found after this date!");
                break;
            }
//сделай новый метод принимающий дату и возвращающий лист нужных компаний;
        }
    }
}
