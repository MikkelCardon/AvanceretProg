package Lektion07.opgave02.opgave2.adapter;

import Lektion07.opgave02.spiritusadapter.Spiritus;

public class Adapter implements Target{

    private final Spiritus adaptee;

    public Adapter(Spiritus adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public double beregnMoms() {
        return adaptee.hentMoms();
    }
}
