package ru.soular.ibs.homework2.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class AppStatist {
    private List<String> wordList;
    private Scanner sc = new Scanner(System.in);
    private Path path;


    public AppStatist() {
        startSequence();
        menu();
    }

    private void startSequence() {


        System.out.println("Hello! This is the AppStatist. Please enter the file location you wish to analyze:");


        while (true) {

            try {
                path = FileHandler.getFile(sc.nextLine());
                this.wordList = FileHandler.parseFile(path);
                break;
            } catch (IOException e) {
                System.out.println("File not found, try again!");
            }

        }
    }

    private void menu() {
        String input;

        while (true) {
            MenuHandler.printMenu();
            input = sc.nextLine();

            switch (input) {
                case "1":
                    printList(wordList);
                    break;
                case "2":
                    printList(wordList, true);
                    break;
                case "3":
                    printStats(wordList);
                    break;
                case "4":
                    System.out.println("Exiting the application, goodbye!");
                    System.exit(0);
                    break;
            }


        }
    }

    private void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private void printList(List<String> list, boolean unique) {
        try {
            List<String> wordList = FileHandler.parseFile(path, true);
            for (String s : wordList) {
                System.out.println(s);
            }


        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    private void printStats(List<String> list) {
        List<String> resultList = StatHandler.getFrequent(StatHandler.getOverallStats(list));

        for (String s : resultList) {
            System.out.println(s);
        }
    }
}