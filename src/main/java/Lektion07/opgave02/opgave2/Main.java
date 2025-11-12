package Lektion07.opgave02.opgave2;

import Lektion07.opgave02.opgave2.adapter.Adapter;
import Lektion07.opgave02.opgave2.adapter.Target;
import Lektion07.opgave02.spiritusadapter.Spiritus;

public class Main {
    public static void main(String[] args) {
        Vare stikkontakt = new ElVare(100, "Stikkontakt");
        Vare agurk = new Fødevare(10, "Agurk");

        Spiritus vodka = new Spiritus(57, "Vodka");
        Target spiritusAdapter = new Adapter(vodka);


        System.out.println(stikkontakt.beregnMoms());
        System.out.println(agurk.beregnMoms());
        System.out.println(spiritusAdapter.beregnMoms());
    }
}
