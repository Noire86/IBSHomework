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
}
