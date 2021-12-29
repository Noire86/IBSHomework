package ru.soular.ibs.homework1;

import ru.soular.ibs.homework1.candy.Caramel;
import ru.soular.ibs.homework1.candy.ChocolateBar;
import ru.soular.ibs.homework1.candy.Lollipop;

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
        candyBox.optimizeByCost(100);

        candyBox.printWeight();
        candyBox.printContents();

    }
}
