package ru.soular.ibs.homework1.candy;

public class Lollipop extends AbstractCandy {

    private String color;

    public Lollipop(String name, int weight, int cost, boolean hasSugar, String color) {
        super(name, weight, cost, hasSugar);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Weight: %d, Cost: %d, Sugar-free: %b, Color: %s", getName(), getWeight(), getCost(), isHasSugar(), getColor());
    }
}
