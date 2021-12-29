package ru.soular.ibs.homework3.classes;

import java.util.List;

public class Share {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String founded;
    private String inn;
    private List<Security> securitiesList;

    public Share(int id, String name, String address, String phoneNumber, String founded, String inn, List<Security> securitiesList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.founded = founded;
        this.inn = inn;
        this.securitiesList = securitiesList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public List<Security> getSecuritiesList() {
        return securitiesList;
    }

    public void setSecuritiesList(List<Security> securitiesList) {
        this.securitiesList = securitiesList;
    }
}
