package Bab3.Tugas.bangunruang;

public class Bola extends BangunRuang {

    public Bola (double jari) {
        super.jari = jari;
    }

    @Override
    public double Luas() {
        return super.Luas(4*phi*jari*jari);
    }

    @Override
    public double Volume() {
        return super.Volume((4/3)*phi*jari*jari*jari);
    }
}
