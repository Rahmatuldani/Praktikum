package Bab3.Tugas.bangunruang;

public class Tabung extends BangunRuang {
    private double tinggi;

    public Tabung(double jari, double tinggi) {
        this.jari = jari;
        this.tinggi = tinggi;
        this.Luas();
        this.Volume();
    }

    @Override
    public double Luas() {
        return super.Luas(2*super.phi*jari*jari);
    }

    @Override
    public double Volume() {
        return super.Volume(super.phi*jari*jari*tinggi);
    }
}
