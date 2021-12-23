package ru.soular.ibs.homework;

public abstract class AbstractCandy {
    private String name;
    private int weight;
    private int cost;
    private String shape;
    private String taste;
    private boolean hasSugar;

    public AbstractCandy(String name, int weight, int cost, String shape, String taste, boolean hasSugar) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.shape = shape;
        this.taste = taste;
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

    public String getShape() {
        return shape;
    }

    public String getTaste() {
        return taste;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }
}
