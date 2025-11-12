package Lektion07.opgave02.opgave2;

public class ElVare extends Vare{
    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms(){
        int pris = getPris();

        double moms = pris * 0.3;

        return moms > 3 ? moms : 3;
    }
}
