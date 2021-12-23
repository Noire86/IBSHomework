package ru.soular.ibs.homework;

import ru.soular.ibs.homework.candy.AbstractCandy;

import java.util.ArrayList;
import java.util.List;

public class CandyBox implements IBoxable {

    private final List<AbstractCandy> array;

    public CandyBox() {
        this.array = new ArrayList<>();
    }


    @Override
    public void add(AbstractCandy candy) {
        array.add(candy);
        System.out.println("Added " + candy.getName() + " into a box of sweets!");
    }

    @Override
    public void remove() {
        array.remove(array.lastIndexOf(array));
        System.out.println("Removing the last candy in the box...");
    }

    @Override
    public void remove(int index) {
        array.remove(index);
        System.out.println("Removing the candy by number " + (index + 1));
    }

    @Override
    public void printWeight() {
        int weight = 0;
        for(AbstractCandy candy : array) {
           weight += candy.getWeight();
        }
        System.out.println("Box weight is: " + weight);
    }

    @Override
    public void printOverallCost() {
        int cost = 0;
        for (AbstractCandy candy : array) {
            cost += candy.getCost();
        }
        System.out.println("Box overall cost is:" + cost);
    }

    @Override
    public void printContents() {
        System.out.println("This box consists of:");
        for (AbstractCandy candy : array) {
            System.out.println(candy.getName());
        }
    }
}
