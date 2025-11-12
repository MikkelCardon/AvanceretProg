package Lektion07.opgave02.opgave2;

public class Fødevare extends Vare{
    public Fødevare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms(){
        return getPris() * 0.05;
    }
}
