package ru.soular.ibs.homework;

import ru.soular.ibs.homework.candy.AbstractCandy;

public interface IBoxable {
    void add(AbstractCandy candy);

    void remove();

    void remove(int index);

    void printWeight();

    void printOverallCost();

    void printContents();
}
