package ru.soular.ibs.homework3.classes;

import java.time.LocalDate;

public class Security {
    private String name;
    private String[] currency;
    private String code;
    private LocalDate date;

    public Security(String name, String[] currency, String code, LocalDate date) {
        this.name = name;
        this.currency = currency;
        this.code = code;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCurrency() {
        return currency;
    }

    public void setCurrency(String[] currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
