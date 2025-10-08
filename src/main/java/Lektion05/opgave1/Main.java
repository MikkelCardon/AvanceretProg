package Lektion05.opgave1;

import Lektion05.opgave1.models.Bil;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Bil> bilHashSet = new HashSet<>();

        Bil bil0 = new Bil(
                "123AB",
                "BMW",
                "I7",
                "Sort"
        );

        Bil bil1 = new Bil(
                "123AB",
                "BMW",
                "I7",
                "Sort"
        );

        Bil bil2 = new Bil(
                "123AB",
                "BMW",
                "I5",
                "Sort"
        );

        bilHashSet.add(bil0);
        bilHashSet.add(bil1);
        bilHashSet.add(bil2);

        System.out.println(bilHashSet);
    }
}
