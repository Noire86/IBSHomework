package ru.soular.ibs.homework3.util;

import ru.soular.ibs.homework3.classes.Company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {
    public static final String[] DATE_FORMATS = {"dd.MM.yyyy", "dd/MM/yyyy", "dd/MM/uu"};


    public static List<Company> checkDates(String date, List<Company> companies) throws NullPointerException, DateTimeException {
        LocalDate userDate = null;
        LocalDate foundedDate = null;
        List<Company> resultList = new ArrayList<>();

        for (Company c : companies) {
            for (String s : DateUtils.DATE_FORMATS) {

                try {
                    userDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(s));
                } catch (DateTimeException ignored) {
                }

                try {
                    foundedDate = LocalDate.parse(c.getFounded(), DateTimeFormatter.ofPattern(s));
                } catch (DateTimeException ignored) {
                }
            }

            if (userDate == null || foundedDate == null) {
                throw new DateTimeException("Invalid date value!");
            }

            if (foundedDate.isAfter(userDate)) {
                resultList.add(c);
            }
        }

        if (resultList.size() == 0) {
            throw new NullPointerException("None of the companies were founded after this date!");
        }

        return resultList;
    }
}
