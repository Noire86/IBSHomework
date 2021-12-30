package ru.soular.ibs.homework3;

import com.google.gson.JsonSyntaxException;
import ru.soular.ibs.homework2.util.FileHandler;
import ru.soular.ibs.homework3.classes.Company;
import ru.soular.ibs.homework3.util.JsonHandler;
import ru.soular.ibs.homework3.util.MenuHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppShares {
    private List<Company> companyList;
    private Scanner sc = new Scanner(System.in);
    private Path path;

    public AppShares() {
        startSequence();
        menu();
    }

    private void startSequence() {
        System.out.println("Hello! This is the AppShares. Please enter the file location you wish to analyze:");

        while (true) {

            try {
                path = FileHandler.getFile(sc.nextLine());
                this.companyList = JsonHandler.deserialize(JsonHandler.getJSON(path));
                break;
            } catch (IOException e) {
                System.out.println("File not found, try again!");
            } catch (JsonSyntaxException e) {
                System.out.println("Error on parsing file: Invalid JSON syntax!");
            }

        }
    }

    private void menu() {
        String input;

        while (true) {
            MenuHandler.printDelimiter();
            MenuHandler.printMenu();
            input = sc.nextLine();

            switch (input) {
                case "1":
                    MenuHandler.printDelimiter();
                    companyList.forEach(MenuHandler::printCompany);
                    break;
                case "2":
                    MenuHandler.printDelimiter();
                    companyList.forEach(MenuHandler::printShares);
                    break;
                case "3":
                    System.out.println("Please enter the desired date:");
                    String date = sc.nextLine();
                    MenuHandler.printCompany(date, companyList);
                    break;
                case "4":
                    System.out.println("Please enter the currency code " + Arrays.toString(JsonHandler.getCurrencies(companyList).toArray()));
                    String currency = sc.nextLine();
                    if (JsonHandler.checkCurrency(currency, companyList)) {
                        MenuHandler.printShares(companyList, currency);
                    }
                    break;
                case "5":
                    System.out.println("Quitting application, goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter correct menu value!");
                    break;
            }
        }
    }

}
