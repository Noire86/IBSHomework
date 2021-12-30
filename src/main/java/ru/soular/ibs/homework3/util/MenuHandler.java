package ru.soular.ibs.homework3.util;

import ru.soular.ibs.homework3.classes.Company;
import ru.soular.ibs.homework3.classes.Security;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuHandler {


    public static void printMenu() {
        System.out.println("Welcome! Use this menu to navigate through the application:\n" +
                "1. Print all companies and their dates of foundation\n" +
                "2. Print all expired shares\n" +
                "3. Print companies that were founded after designated date\n" +
                "4. Print all shares by currency type\n" +
                "5. Quit application");

    }

    public static void printDelimiter() {
        System.out.println("============================");
    }

    public static void printCompany(Company c) {
        LocalDate founded = LocalDate.parse(c.getFounded(), DateTimeFormatter.ofPattern(DateUtils.DATE_FORMATS[0]));
        System.out.println(c.getName() + " - Was founded since: " + founded.format(DateTimeFormatter.ofPattern("dd.MM.yy")));
    }

    public static void printCompany(String date, List<Company> list) {
        System.out.println("Companies that were founded after " + date + ":");

        try {
            DateUtils.checkDates(date, list).forEach(MenuHandler::printCompany);
        } catch (NullPointerException | DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printShares(Company c) {
        List<Security> expiredShares = c.getSecurities().stream()
                .filter(security -> LocalDate.now().isAfter(LocalDate.parse(security.getDate(), DateTimeFormatter.ofPattern(DateUtils.DATE_FORMATS[0]))))
                .collect(Collectors.toList());
        System.out.println("--------------------------");
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

}
