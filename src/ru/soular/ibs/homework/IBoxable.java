package ru.soular.ibs.homework;

public interface IBoxable {
    void add(Object o);

    void remove();
    void remove(int index);

    String printWeight();
    String printOverallCost();
    String printContents();
}
