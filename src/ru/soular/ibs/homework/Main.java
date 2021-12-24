package ru.soular.ibs.homework;

import ru.soular.ibs.homework.candy.Caramel;
import ru.soular.ibs.homework.candy.ChocolateBar;
import ru.soular.ibs.homework.candy.Lollipop;

public class Main {
    public static void main(String[] args) {
        CandyBox candyBox = new CandyBox();

        candyBox.add(new ChocolateBar("Mars", 150, 40, true, "Milk"));
        candyBox.add(new Caramel("Caramelly", 100, 30, true, true));
        candyBox.add(new Lollipop("Chupa", 90, 25, true, "green"));
        candyBox.add(new Lollipop("Chupa", 90, 25, true, "red"));
        candyBox.add(new Lollipop("Chupa", 90, 25, true, "yellow"));
        candyBox.add(new Lollipop("Chupa", 90, 25, true, "purple"));


        candyBox.printOverallCost();
        candyBox.optimizeCost(400);

        candyBox.printWeight();
        candyBox.printContents();

    }
}
