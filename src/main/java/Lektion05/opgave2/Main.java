package Lektion05.opgave2;

import Lektion05.opgave1.models.Bil;

public class Main {
    public static void main(String[] args) {
        DictionaryLinked<Bil, Integer> bilDictonary = new DictionaryLinked<>();

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

        bilDictonary.put(bil0, 1);
        bilDictonary.put(bil1, 0);
        bilDictonary.put(bil2, 1);

        System.out.println(bilDictonary.get(bil0));
        System.out.println(bilDictonary.get(bil1));
        System.out.println(bilDictonary.get(bil2));
    }
}
