package ru.soular.ibs.homework.candy;

public abstract class AbstractCandy {
    private String name;
    private int weight;
    private int cost;
    private boolean hasSugar;

    public AbstractCandy(String name, int weight, int cost, boolean hasSugar) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.hasSugar = hasSugar;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }
}
