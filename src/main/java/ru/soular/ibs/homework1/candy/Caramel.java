package ru.soular.ibs.homework1.candy;

public class Caramel extends AbstractCandy {

    private boolean chewable;

    public Caramel(String name, int weight, int cost, boolean hasSugar, boolean chewable) {
        super(name, weight, cost, hasSugar);
        this.chewable = chewable;
    }

    public boolean isChewable() {
        return chewable;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Weight: %d, Cost: %d, Sugar-free: %b, Chewable: %b", getName(), getWeight(), getCost(), isHasSugar(), isChewable());
    }
}
