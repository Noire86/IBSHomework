package ru.soular.ibs.homework.candy;

public class Caramel extends AbstractCandy {

    private boolean chewable;

    public Caramel(String name, int weight, int cost, boolean hasSugar, boolean chewable) {
        super(name, weight, cost, hasSugar);
        this.chewable = chewable;
    }

    public boolean isChewable() {
        return chewable;
    }
}
