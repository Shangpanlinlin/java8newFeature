package com.asd.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Java8TesterForLambdaSort {
    static  String[] players = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka", "David Ferrer",
            "Roger Federer", "Andy Murray",
            "Tomas Berdych", "Juan Martin Del Potro",
            "Richard Gasquet", "John Isner"};

    public static void main(String[] args) {
        //使用匿名内部类根据name排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });
        System.out.println(Arrays.toString(players));
        Comparator<String> sortByName = (String s1, String s2) -> s1.compareTo(s2);
        Arrays.sort(players, sortByName);
        Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));

        Arrays.sort(players, (s1, s2) -> s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        System.out.println(Arrays.toString(players));

        //name length sort
        Arrays.sort(players, (s1,s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(players));
    }
}
