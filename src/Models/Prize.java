package Models;

import java.util.ArrayList;

public class Prize {

    private static ArrayList<Integer> values;

    public static int getPrize(int questionNumber) {

        //money level stacked untill money is earned
        //Different question number represent different prize
        int prize;
        values = new ArrayList<>();
        values.add(500);
        values.add(1000);
        values.add(2000);
        values.add(3000);
        values.add(5000);
        values.add(7500);
        values.add(10000);
        values.add(12500);
        values.add(15000);
        values.add(25000);
        values.add(50000);
        values.add(100000);
        values.add(250000);
        values.add(500000);
        values.add(1000000);

        prize = values.get(questionNumber);
        return prize;

    }
}
