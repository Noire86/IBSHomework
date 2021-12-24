package ru.soular.ibs.homework1;

import ru.soular.ibs.homework1.candy.AbstractCandy;
import ru.soular.ibs.homework1.candy.Caramel;

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
        System.out.println("Box weight is: " + getOverallWeight());
    }

    @Override
    public void printOverallCost() {
        System.out.println("Box overall cost is: " + getOverallCost());
    }

    @Override
    public void printContents() {
        System.out.println("This box consists of: ");
        for (AbstractCandy candy: array) {
            System.out.printf("Name: %s, Weight: %s, Cost: %s, Sugar-free: %b\n", candy.getName(), candy.getWeight(), candy.getCost(), !candy.isHasSugar());
        }
    }

    private int getOverallWeight() {
        int weight = 0;
        for (AbstractCandy candy : array) {
            weight += candy.getWeight();
        }
        return weight;
    }

    private int getOverallCost() {
        int cost = 0;
        for (AbstractCandy candy : array) {
            cost += candy.getCost();
        }
        return cost;
    }

    private AbstractCandy getMinWeightCandy() {
        int minWeight = Integer.MAX_VALUE;

        for (AbstractCandy candy : array) { // поиск самого меньшего веса
            if (candy.getWeight() < minWeight) {
                minWeight = candy.getWeight();
            }
        }

        for (AbstractCandy candy : array) {//пробегаемся по листу и выбираем самый легкий обьект, возвращаем его
            if (minWeight == candy.getWeight()) {
                return candy;
            }
        }
        return null;
    }

    private AbstractCandy getMinCostCandy() {
        int minCost = Integer.MAX_VALUE;

        for (AbstractCandy candy : array) { // поиск меньшей цены
            if (candy.getCost() < minCost) {
                minCost = candy.getCost();
            }
        }

        for (AbstractCandy candy : array) { // пробегаемся по листу и выбираем самый дешевый обьект, возвращаем его
            if (minCost == candy.getCost()) {
                return candy;
            }
        }
        return null;
    }

    public void optimizeWeight(int desirableWeight) {
        if (desirableWeight < getOverallWeight()) {

            while (desirableWeight < getOverallWeight() && getMinWeightCandy() != null) {
                array.remove(getMinWeightCandy());
            }

            System.out.println("Successful weight optimization! Current weight: " + getOverallWeight());

        } else {
            System.out.println("Current weight already meets your request");
        }
    }

    public void optimizeCost(int desirableCost) {
        if (desirableCost < getOverallCost()) {

            while (desirableCost < getOverallCost() && getMinCostCandy() != null) {
                array.remove(getMinCostCandy());
            }

            System.out.println("Successful cost optimization! Current cost: " + getOverallCost());

        } else {
            System.out.println("Current cost already meets your request");
        }
    }
}
