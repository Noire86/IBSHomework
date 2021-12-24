package ru.soular.ibs.homework1.candy;

public class ChocolateBar extends AbstractCandy {

    private String chocolateType;

    public ChocolateBar(String name, int weight, int cost, boolean hasSugar, String chocolateType) {
        super(name, weight, cost, hasSugar);
        this.chocolateType = chocolateType;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Weight: %d, Cost: %d, Sugar-free: %b, Chocolate: %s", getName(), getWeight(), getCost(), isHasSugar(), getChocolateType());
    }
}
